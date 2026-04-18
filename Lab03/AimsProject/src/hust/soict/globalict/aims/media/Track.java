// LAB 3 SESSION 11

package hust.soict.globalict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    // Hiện thực hàm play() cho Track
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    
    public boolean equals(Object obj) {     
    	if (this == obj) {
            return true;
        }
        // Kiểm tra obj có phải là Track không
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }
        // Ép kiểu an toàn
        Track other = (Track) obj;
        
        // Hai Track giống nhau nếu cùng title VÀ cùng độ dài
        return this.length == other.getLength() && 
               this.title != null && 
               this.title.equals(other.getTitle());
    }
}
    }
}