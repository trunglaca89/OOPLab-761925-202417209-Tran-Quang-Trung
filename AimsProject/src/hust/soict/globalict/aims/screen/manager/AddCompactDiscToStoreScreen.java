package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javax.swing.JTextField;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private final JTextField artistField = new JTextField();
    private final JTextField directorField = new JTextField();
    private final JTextField lengthField = new JTextField();
    private final JTextField tracksField = new JTextField();

    public AddCompactDiscToStoreScreen(Store store, Runnable refreshAction) {
        super("Add CD", store, refreshAction);
    }

    @Override
    protected void addSpecificFields() {
        addField("Artist", artistField);
        addField("Director", directorField);
        addField("Length", lengthField);
        addField("Tracks (title:length, ...)", tracksField);
    }

    @Override
    protected Media createMedia() {
        CompactDisc compactDisc = new CompactDisc(
                readText(titleField, "Title"),
                readText(categoryField, "Category"),
                readText(directorField, "Director"),
                readInt(lengthField, "Length"),
                readCost(),
                readText(artistField, "Artist"));

        String tracks = tracksField.getText().trim();
        if (!tracks.isEmpty()) {
            for (String item : tracks.split(",")) {
                String[] parts = item.trim().split(":");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Track format must be title:length.");
                }
                compactDisc.addTrack(new Track(parts[0].trim(), parseTrackLength(parts[1].trim())));
            }
        }
        return compactDisc;
    }

    private int parseTrackLength(String value) {
        try {
            int length = Integer.parseInt(value);
            if (length < 0) {
                throw new NumberFormatException();
            }
            return length;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Track length must be a non-negative integer.");
        }
    }
}
