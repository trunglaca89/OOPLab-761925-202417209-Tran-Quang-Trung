package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh Title trước
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) return titleCompare;
        
        // Nếu trùng Title thì so sánh Cost giảm dần
        return Float.compare(m2.getCost(), m1.getCost());
    }
}