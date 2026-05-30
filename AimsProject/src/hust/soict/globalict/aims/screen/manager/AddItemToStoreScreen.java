package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;
    private final Runnable refreshAction;
    protected final JTextField titleField = new JTextField();
    protected final JTextField categoryField = new JTextField();
    protected final JTextField costField = new JTextField();
    protected final JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));

    protected AddItemToStoreScreen(String title, Store store, Runnable refreshAction) {
        super(title);
        this.store = store;
        this.refreshAction = refreshAction;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        addField("Title", titleField);
        addField("Category", categoryField);
        addField("Cost", costField);
        addSpecificFields();

        JButton addButton = new JButton("Add to store");
        addButton.addActionListener(event -> addMedia());

        add(formPanel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected void addField(String label, JTextField field) {
        formPanel.add(new JLabel(label));
        formPanel.add(field);
    }

    private void addMedia() {
        try {
            Media media = createMedia();
            store.addMedia(media);
            refreshAction.run();
            dispose();
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected String readText(JTextField field, String label) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException(label + " is required.");
        }
        return value;
    }

    protected int readInt(JTextField field, String label) {
        try {
            int value = Integer.parseInt(readText(field, label));
            if (value < 0) {
                throw new NumberFormatException();
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(label + " must be a non-negative integer.");
        }
    }

    protected float readCost() {
        try {
            float value = Float.parseFloat(readText(costField, "Cost"));
            if (value < 0) {
                throw new NumberFormatException();
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Cost must be a non-negative number.");
        }
    }

    protected abstract void addSpecificFields();

    protected abstract Media createMedia();
}
