package Aims;

public class DigitalVideoDisc {
	
    // đếm số lượng đĩa đã tạo
    private static int nbDigitalVideoDiscs = 0;
    
    private int id;
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor 1: Chỉ tạo bằng Title
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 2: Tạo bằng Category, Title, Cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 3: Tạo bằng Director, Category, Title, Cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 4: Tạo bằng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Chỉ tạo Getters 
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    
    // Section 15 yêu cầu thêm hàm setTitle để test Passing Parameter
    public void setTitle(String title) {
        this.title = title;
    }
}