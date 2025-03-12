import java.awt.*;
import javax.swing.*;

public class window extends JFrame {

    JPanel panel = new JPanel();
    int score = 0;
    JLabel label = new JLabel("SCORE: " + score);
    JPanel subPanel = new JPanel();

    public window() {
        this.setTitle("Rasheeds Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 600);

        this.getContentPane().add(subPanel);
        customLayout();

        this.setVisible(true);
    }

    private void customLayout() {

        // Create the northPanel for the cards and set the layout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        // Create southPanel for the score section
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        // Added the label to southPanel to represent score
        southPanel.add(this.label);

        // Added the two panels to the subPanel
        subPanel.add(northPanel);
        subPanel.add(southPanel);

    }

    private void cardAdder() {

    }

    private void ButtonMaker() {

    }

}
