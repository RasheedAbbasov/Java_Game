import java.awt.*;
import javax.swing.*;


public class window extends JFrame  {

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton flappy = new JButton();
        ImageIcon flappyPic = new ImageIcon("assets/pngegg.png");





    public window() {
        this.setTitle("Rasheeds Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 600);

        flappy.setIcon(flappyPic);
        flappy.setPreferredSize(new Dimension(150, 150));

        this.getContentPane().add(flappy);
















        this.setVisible(true);
    }

    private void setButton() {

        flappy.setIcon(flappyPic);
    }
}
