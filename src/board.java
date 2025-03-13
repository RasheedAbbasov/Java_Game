import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class board extends JFrame {

    JPanel panel = new JPanel();
    JButton buttonRestart = new JButton("Restart");
    ImageIcon cross = new ImageIcon("assets/cross.png");
    ImageIcon circle = new ImageIcon("assets/circle.png");
    boolean player1 = true;
    boolean player2 = false;

    public board() {
        this.setTitle("Tic-Tac-Toe");
        this.setSize(500, 600);
        this.setResizable(false);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customLayout();

        this.setVisible(true);
    }

    private void customLayout() {

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.CYAN);

        JPanel northPanel = new JPanel();
        // northPanel.setBackground(Color.GREEN);
        northPanel.setPreferredSize(new Dimension(500, 500));
        northPanel.setLayout(new FlowLayout());

        panel.setLayout(new FlowLayout());
        panel.add(northPanel);
        panel.add(southPanel);

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                JButton button = new JButton("Click Me");
                button.setPreferredSize(new Dimension(150, 150));
                button.setBackground(Color.WHITE);

                northPanel.add(button);
            }
        }

    }

    private void changeButton() {

    }

}
