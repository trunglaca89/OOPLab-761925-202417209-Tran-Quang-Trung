// LAB 3 SESSION 10.1

package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Getter cho các thuộc tính riêng của Disc 
    public int getLength() { return length; }
    public String getDirector() { return director; }

    public Disc() {
        super();
    }

 // CẬP NHẬT: Dùng super() thay vì dùng các hàm set
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Đá lên cho Media xử lý 3 thuộc tính này
        this.director = director;
        this.length = length;
    }
}