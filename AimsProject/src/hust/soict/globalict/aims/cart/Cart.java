// LAB03 SESSION 12 | LAB05 SESSION 6.3 + 9: ObservableList + LimitExceededException

package hust.soict.globalict.aims.cart;

import java.util.Comparator;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media '" + media.getTitle() + "' has been added.");
            } else {
                System.out.println("The media '" + media.getTitle() + "' is already in the cart.");
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit (" + MAX_NUMBERS_ORDERED + ")");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }

    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                return;
            }
        }
        System.out.println("No match found for id: " + id);
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void sortItems(Comparator<Media> comparator) {
        itemsOrdered.sort(comparator);
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
