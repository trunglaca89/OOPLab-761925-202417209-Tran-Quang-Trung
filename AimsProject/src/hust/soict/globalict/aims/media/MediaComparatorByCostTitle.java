package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. Sắp xếp theo Cost (Giảm dần)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        
        // Nếu giá khác nhau thì trả về kết quả luôn
        if (costCompare != 0) {
            return costCompare;
        }
        
        // 2. Nếu giá bằng nhau, sắp xếp theo Title 
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}