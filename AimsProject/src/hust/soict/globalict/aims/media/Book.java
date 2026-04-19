package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

// Book kế thừa từ Media 
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }
    
    // THÊM: Constructor cho Book
    public Book(String title, String category, float cost) {
        super(title, category, cost); // Đá lên cho Media
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added.");
        } else {
            System.out.println("Author '" + authorName + "' already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed.");
        } else {
            System.out.println("Author '" + authorName + "' not found.");
        }
    }
    
    public String toString() {
    	return "Book - " + getTitle() + " - " + getCategory() + " - Cost: " + getCost() + " $";
    }
}