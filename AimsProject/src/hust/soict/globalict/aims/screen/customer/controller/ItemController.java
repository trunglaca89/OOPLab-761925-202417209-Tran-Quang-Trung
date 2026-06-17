package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {

    @FXML private Label lblTitle;
    @FXML private Label lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;
    private Cart cart;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        if (!(media instanceof Playable)) {
            btnPlay.setVisible(false);
            btnPlay.setManaged(false);
        }
    }

    @FXML
    private void btnAddToCartClicked() {
        try {
            cart.addMedia(media);
            btnAddToCart.setText("Added");
            btnAddToCart.setDisable(true);
        } catch (LimitExceededException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void btnPlayClicked() {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
