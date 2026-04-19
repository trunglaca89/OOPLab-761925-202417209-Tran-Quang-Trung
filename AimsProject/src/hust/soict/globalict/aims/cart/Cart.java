// LAB03 SESSION 12

package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;

public class Cart {
    // Sử dụng ArrayList để quản lý danh sách Media
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Thêm media vào giỏ hàng 
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the cart.");
        }
    }

    // Xóa media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not in the cart.");
        }
    }

    // Tính tổng chi phí 
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // In danh sách giỏ hàng 
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm bằng tiêu đề 
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
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Dọn giỏ hàng sau khi đặt
    public void clear() {
        itemsOrdered.clear();
    }
}