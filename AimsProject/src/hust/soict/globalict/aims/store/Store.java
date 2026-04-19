// LAB 3 SESSION 13

package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;

public class Store {
    // Chuyển sang dùng ArrayList để lưu trữ đa dạng các loại Media
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    // Xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }
}