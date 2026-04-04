package Aims;

public class Aims {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới (anOrder)
        Cart anOrder = new Cart();

        // 2. Tạo các đối tượng DVD mới và cho vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // 3. In ra danh sách chi tiết và tổng tiền hiện tại để kiểm tra
        System.out.println("Current Cart:");
        anOrder.printCart();
        
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // 4. Thử xóa một đĩa ra khỏi giỏ hàng
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // 5. In lại danh sách mới và tổng tiền xem đã trừ đúng chưa
        System.out.println("Cart after removal:");
        anOrder.printCart();
        
        System.out.println("Total Cost after removal is: ");
        System.out.println(anOrder.totalCost());
    }
}