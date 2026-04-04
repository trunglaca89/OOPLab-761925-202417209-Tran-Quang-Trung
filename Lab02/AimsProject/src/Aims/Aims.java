package Aims;

public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Thêm đĩa vào giỏ (test cả hàm add 1 đĩa và hàm overload)
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2, dvd3); // Sử dụng hàm overload truyền 2 biến

        // In giỏ hàng và tổng tiền
        anOrder.printCart();

        // Test tính năng xóa đĩa
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // In lại giỏ hàng sau khi xóa
        anOrder.printCart();
    }
}