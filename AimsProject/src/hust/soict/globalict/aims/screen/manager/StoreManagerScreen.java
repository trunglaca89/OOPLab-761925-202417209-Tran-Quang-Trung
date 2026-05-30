package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class StoreManagerScreen extends JFrame {
    private final Store store;
    private final JPanel centerPanel = new JPanel();

    public StoreManagerScreen(Store store) {
        super("AIMS Store Manager");
        this.store = store;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        add(createHeader(), BorderLayout.NORTH);
        add(new JScrollPane(centerPanel), BorderLayout.CENTER);

        refreshStore();
        setSize(1024, 768);
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(event -> new AddBookToStoreScreen(store, this::refreshStore));
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(event -> new AddCompactDiscToStoreScreen(store, this::refreshStore));
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(event -> new AddDigitalVideoDiscToStoreScreen(store, this::refreshStore));

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);
        menu.add(updateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setPreferredSize(new Dimension(100, 72));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));

        JLabel title = new JLabel("AIMS");
        title.setForeground(new Color(0, 102, 102));
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        header.add(title);
        header.add(Box.createHorizontalStrut(20));
        header.add(new JLabel("Store Manager"));
        return header;
    }

    public void refreshStore() {
        centerPanel.removeAll();
        centerPanel.setLayout(new GridLayout(0, 3, 16, 16));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        for (Media media : store.getItemsInStore()) {
            centerPanel.add(new MediaStore(media, store, this::refreshStore));
        }

        if (store.getItemsInStore().isEmpty()) {
            JPanel emptyPanel = new JPanel();
            emptyPanel.setLayout(new BoxLayout(emptyPanel, BoxLayout.Y_AXIS));
            emptyPanel.add(new JLabel("Store is empty"));
            centerPanel.add(emptyPanel);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
