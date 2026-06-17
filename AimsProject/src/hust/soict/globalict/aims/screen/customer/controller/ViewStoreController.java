package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    @FXML private GridPane gridPane;

    private Store store;
    private Cart cart;

    public void setData(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        loadItems();
    }

    private void loadItems() {
        gridPane.getChildren().clear();
        int col = 0, row = 0;
        final int COLS = 3;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/hust/soict/globalict/aims/screen/customer/view/Item.fxml"));
                Parent itemNode = loader.load();
                ItemController itemController = loader.getController();
                itemController.setData(media, cart);
                gridPane.add(itemNode, col, row);
                col++;
                if (col == COLS) {
                    col = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnViewCartPressed() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml"));
            Parent root = loader.load();
            CartController cartController = loader.getController();
            cartController.setData(cart, store, (Stage) gridPane.getScene().getWindow());

            Stage stage = (Stage) gridPane.getScene().getWindow();
            stage.setScene(new Scene(root, 1024, 768));
            stage.setTitle("AIMS - Cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
