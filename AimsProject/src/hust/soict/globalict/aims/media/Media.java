package hust.soict.globalict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {}

    public Media(String title, String category, float cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative: " + cost);
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative: " + cost);
        this.cost = cost;
    }

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

    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Cannot compare with null");
        int titleCmp = this.title == null ? -1 : this.title.compareToIgnoreCase(other.getTitle());
        if (titleCmp != 0) return titleCmp;
        return Float.compare(other.getCost(), this.cost); // cost descending
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}