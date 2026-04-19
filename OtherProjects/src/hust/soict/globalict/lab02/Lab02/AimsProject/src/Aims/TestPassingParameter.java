package Aims;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi hàm swap (hoán đổi)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi hàm đổi title
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Hàm hoán đổi (thực tế sẽ KHÔNG hoạt động ngoài phạm vi hàm này do Pass-by-value)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm đổi tên
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // Dòng này làm thay đổi title thực tế vì nó thao tác trực tiếp vào thuộc tính của object
        dvd = new DigitalVideoDisc(oldTitle); // Dòng này vô nghĩa bên ngoài hàm
    }
}