package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import javax.swing.JTextField;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private final JTextField directorField = new JTextField();
    private final JTextField lengthField = new JTextField();

    public AddDigitalVideoDiscToStoreScreen(Store store, Runnable refreshAction) {
        super("Add DVD", store, refreshAction);
    }

    @Override
    protected void addSpecificFields() {
        addField("Director", directorField);
        addField("Length", lengthField);
    }

    @Override
    protected Media createMedia() {
        return new DigitalVideoDisc(
                readText(titleField, "Title"),
                readText(categoryField, "Category"),
                readText(directorField, "Director"),
                readInt(lengthField, "Length"),
                readCost());
    }
}
