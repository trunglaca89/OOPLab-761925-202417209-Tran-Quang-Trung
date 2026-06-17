package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Number>  colMediaId;
    @FXML private TableColumn<Media, String>  colMediaTitle;
    @FXML private TableColumn<Media, String>  colMediaCategory;
    @FXML private TableColumn<Media, Number>  colMediaCost;
    @FXML private Label   costLabel;
    @FXML private Button  btnPlay;
    @FXML private Button  btnRemove;
    @FXML private TextField   tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private Cart  cart;
    private Store store;
    private Stage stage;

    public void setData(Cart cart, Store store, Stage stage) {
        this.cart  = cart;
        this.store = store;
        this.stage = stage;
        initialize();
    }

    private void initialize() {
        colMediaId.setCellValueFactory(
                data -> new SimpleIntegerProperty(data.getValue().getId()));
        colMediaTitle.setCellValueFactory(
                data -> new SimpleStringProperty(data.getValue().getTitle()));
        colMediaCategory.setCellValueFactory(
                data -> new SimpleStringProperty(data.getValue().getCategory()));
        colMediaCost.setCellValueFactory(
                data -> new SimpleFloatProperty(data.getValue().getCost()));

        tblMedia.setItems(cart.getItemsOrdered());
        updateCostLabel();

        cart.getItemsOrdered().addListener(
                (javafx.collections.ListChangeListener<Media>) change -> updateCostLabel());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

        tfFilter.textProperty().addListener(
                (obs, oldVal, newVal) -> showFilteredMedia(newVal));
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateCostLabel() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }
        FilteredList<Media> filtered = new FilteredList<>(cart.getItemsOrdered());
        if (radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(filterText.trim());
                filtered.setPredicate(m -> m.getId() == id);
            } catch (NumberFormatException e) {
                filtered.setPredicate(m -> false);
            }
        } else {
            filtered.setPredicate(
                    m -> m.getTitle().toLowerCase().contains(filterText.toLowerCase()));
        }
        tblMedia.setItems(filtered);
    }

    @FXML
    private void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            try {
                ((Playable) selected).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    private void btnViewStorePressed() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
            Parent root = loader.load();
            ViewStoreController storeController = loader.getController();
            storeController.setData(store, cart);

            stage.setScene(new Scene(root, 1024, 768));
            stage.setTitle("AIMS - Store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnPlaceOrderPressed() {
        System.out.println("Order placed! Total: " + cart.totalCost() + " $");
        cart.clear();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateCostLabel();
    }
}
