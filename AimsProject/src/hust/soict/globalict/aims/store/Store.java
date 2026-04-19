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
    
    // Tìm kiếm media trong kho theo tiêu đề 
    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
     // In danh sách các sản phẩm đang có trong kho (Hàm vừa được thêm)
     public void print() {
    	 System.out.println("********************STORE********************");
         System.out.println("Items currently in store:");
         if (itemsInStore.isEmpty()) {
             System.out.println("The store is empty!");
         } else {
             for (int i = 0; i < itemsInStore.size(); i++) {
                 System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
             }
         }
         System.out.println("*********************************************");
     }
 }