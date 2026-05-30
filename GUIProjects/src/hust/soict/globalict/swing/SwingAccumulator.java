package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SwingAccumulator extends JFrame {
    private final JTextField tfInput = new JTextField("0", 10);
    private final JTextField tfOutput = new JTextField("0", 10);
    private int sum;

    public SwingAccumulator() {
        super("Swing Accumulator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 2, 8, 8));
        panel.add(new JLabel("Enter an integer:"));
        panel.add(tfInput);
        panel.add(new JLabel("The accumulated sum is:"));
        tfOutput.setEditable(false);
        panel.add(tfOutput);

        JButton btnCount = new JButton("Count");
        btnCount.addActionListener(event -> {
            int number = Integer.parseInt(tfInput.getText());
            sum += number;
            tfInput.setText("");
            tfOutput.setText(String.valueOf(sum));
        });

        add(panel, BorderLayout.CENTER);
        add(btnCount, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAccumulator().setVisible(true));
    }
}
