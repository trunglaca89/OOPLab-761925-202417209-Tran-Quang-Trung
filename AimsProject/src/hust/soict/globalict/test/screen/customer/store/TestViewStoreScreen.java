package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Store store = new Store();
        Cart  cart  = new Cart();

        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f));

        Book book = new Book("Effective Java", "Programming", 45.50f);
        book.addAuthor("Joshua Bloch");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Queen", 10, 20.25f, "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));
        store.addMedia(cd);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
        Parent root = loader.load();

        ViewStoreController controller = loader.getController();
        controller.setData(store, cart);

        primaryStage.setUserData(store);
        primaryStage.setTitle("AIMS - Store");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
