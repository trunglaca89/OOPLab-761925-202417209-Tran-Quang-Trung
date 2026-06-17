package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added.");
        } else {
            System.out.println("Author '" + authorName + "' already exists.");
        }
    }

    public void removeAuthor(String authorName) throws IllegalArgumentException {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed.");
        } else {
            throw new IllegalArgumentException("ERROR: Author '" + authorName + "' is not listed in this book.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Cost: " + getCost() + " $";
    }
}