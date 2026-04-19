package hust.soict.globalict.test.polymorphism;

import java.util.ArrayList;
import java.util.List;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class TestPolymorphism {
    public static void main(String[] args) {
        // 1. Tạo một ArrayList chứa các đối tượng kiểu Media
        List<Media> mediae = new ArrayList<Media>();

        // 2. Tạo các loại media khác nhau (CD, DVD, Book)
        CompactDisc cd = new CompactDisc("Star Wars", "Sci-Fi", "George Lucas", 120, 24.95f, "John Williams");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("The Valley of Fear", "Detective", 20.00f);

        // 3. Thêm tất cả vào chung một danh sách
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // 4. Duyệt danh sách và in ra thông tin
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}