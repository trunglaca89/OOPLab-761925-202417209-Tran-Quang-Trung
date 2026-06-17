package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MediaStore extends JPanel {
    public MediaStore(Media media, Store store, Runnable refreshAction) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JLabel title = new JLabel(media.getTitle());
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton viewButton = new JButton("View");
        viewButton.addActionListener(event -> JOptionPane.showMessageDialog(this, media.toString(), "Media", JOptionPane.INFORMATION_MESSAGE));
        buttonPanel.add(viewButton);

        if (media instanceof Playable playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(event -> {
                try {
                    playable.play();
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            buttonPanel.add(playButton);
        }

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(event -> {
            store.removeMedia(media);
            refreshAction.run();
        });
        buttonPanel.add(removeButton);

        add(title, BorderLayout.NORTH);
        add(cost, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
