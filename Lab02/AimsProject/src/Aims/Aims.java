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
        
        // 3. Thêm một danh sách đĩa vào giỏ
        DigitalVideoDisc[] dvdList = {
            new DigitalVideoDisc("Cinderella", "Animation", 15.5f),
            new DigitalVideoDisc("The Jungle", "Adventure", 20.0f)
        };
        System.out.println("\n--- Testing Overloading: Add by Array ---");
        anOrder.addDigitalVideoDisc(dvdList);

        // 4. Thêm trực tiếp 2 đĩa vào giỏ
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Science Fiction", 25.0f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Titanic", "Romance", 22.0f);
        System.out.println("\n--- Testing Overloading: Add 2 DVDs ---");
        anOrder.addDigitalVideoDisc(dvd4, dvd5);
        
        // 5. In ra danh sách chi tiết và tổng tiền hiện tại để kiểm tra
        System.out.println("Current Cart:");
        anOrder.printCart();
        
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // 6. Thử xóa một đĩa ra khỏi giỏ hàng
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // 7. In lại danh sách mới và tổng tiền xem đã trừ đúng chưa
        System.out.println("Cart after removal:");
        anOrder.printCart();
        
        System.out.println("Total Cost after removal is: ");
        System.out.println(anOrder.totalCost());
        
        package Aims;

        public class Aims {
            public static void main(String[] args) {

                // 8. Test truyền tham số
                System.out.println("\n--- Testing Passing Parameter ---");
                DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
                DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

                // Thử tráo đổi 2 đĩa (Dùng hàm swap từ class TestPassingParameter)
                TestPassingParameter.swap(jungleDVD, cinderellaDVD);
                System.out.println("After swap: jungle dvd title: " + jungleDVD.getTitle());
                System.out.println("After swap: cinderella dvd title: " + cinderellaDVD.getTitle());

                // Thử đổi tên đĩa
                TestPassingParameter.changeTitle(jungleDVD, cinderellaDVD.getTitle());
                System.out.println("After changeTitle: jungle dvd title: " + jungleDVD.getTitle());
            }
        }
    }
}