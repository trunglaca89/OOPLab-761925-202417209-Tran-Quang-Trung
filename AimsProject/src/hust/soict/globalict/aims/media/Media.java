package hust.soict.globalict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    public Media() {
        // Constructor mặc định 
    }
    
    // THÊM: Constructor đầy đủ
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    // THÊM: Constructor chỉ có title
    public Media(String title) {
        this.title = title;
    }

    // Các phương thức Accessor (Getter/Setter) cho các thuộc tính chung
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    // LAB05 SESSION 12: equals kiểm tra cả title VÀ cost
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;
        if (this.title == null) return false;
        return this.title.equals(other.getTitle()) && this.cost == other.getCost();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    // LAB05 SESSION 12: compareTo - sắp xếp tự nhiên theo title rồi đến cost
    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Cannot compare with null");
        int titleCmp = this.title == null ? -1 : this.title.compareToIgnoreCase(other.getTitle());
        if (titleCmp != 0) return titleCmp;
        return Float.compare(other.getCost(), this.cost); // cost descending
    }

    // SESSION 17: COMPARATOR
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}