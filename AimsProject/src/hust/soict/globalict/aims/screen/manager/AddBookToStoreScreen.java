package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import javax.swing.JTextField;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private final JTextField authorsField = new JTextField();

    public AddBookToStoreScreen(Store store, Runnable refreshAction) {
        super("Add Book", store, refreshAction);
    }

    @Override
    protected void addSpecificFields() {
        addField("Authors (comma separated)", authorsField);
    }

    @Override
    protected Media createMedia() {
        Book book = new Book(
                readText(titleField, "Title"),
                readText(categoryField, "Category"),
                readCost());

        String authors = authorsField.getText().trim();
        if (!authors.isEmpty()) {
            for (String author : authors.split(",")) {
                book.addAuthor(author);
            }
        }
        return book;
    }
}
