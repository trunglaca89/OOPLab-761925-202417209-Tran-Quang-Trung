package hust.soict.globalict.aims.media;

// Lớp cha trừu tượng cho mọi loại Media 
public abstract class Media {
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
}