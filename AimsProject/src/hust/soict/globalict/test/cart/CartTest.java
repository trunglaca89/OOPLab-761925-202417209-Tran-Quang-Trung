package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.err.println(e.getMessage());
        }

        // Test the print method
        cart.print();

        // Test the search methods
        System.out.println("\n--- SEARCH BY ID ---");
        cart.searchById(1); // Sẽ tìm thấy The Lion King (ID 1)
        cart.searchById(5); // Sẽ in ra No match found

        System.out.println("\n--- SEARCH BY TITLE ---");
        cart.searchByTitle("Star Wars"); // Sẽ tìm thấy Star Wars
        cart.searchByTitle("Aladin"); // Sẽ tìm thấy Aladin
        cart.searchByTitle("Cinderella"); // Sẽ in ra No match found
    }
}
