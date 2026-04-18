// LAB 3 SESSION 13
package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng mới
        Store store = new Store();

        // Tạo một vài đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Test thêm đĩa vào cửa hàng (Dùng hàm addMedia mới)
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Test xóa đĩa khỏi cửa hàng (Dùng hàm removeMedia mới)
        store.removeMedia(dvd2); 
        
        // Test xóa đĩa không có trong cửa hàng
        store.removeMedia(dvd2); 
    }
}