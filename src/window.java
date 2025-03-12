import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class window extends JFrame {

    Scanner scnr = new Scanner(System.in);
    JPanel panel = new JPanel();
    public static int boardSize = 0;
    int score = 0;
    ArrayList<String> cardWords = new ArrayList<>();
    JButton matchButton = new JButton();

    JLabel label = new JLabel("SCORE: " + score);
    JPanel subPanel = new JPanel();

    public window() {
        this.setTitle("Rasheeds Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 600);

        subPanel.setLayout(new FlowLayout());
        this.getContentPane().add(subPanel);
        fileReader();
        customLayout();
        askUser();

        this.setVisible(true);
    }

    private void customLayout() {

        // Create the northPanel for the cards and set the layout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.setBackground(Color.LIGHT_GRAY);
        northPanel.setPreferredSize(new Dimension(500, 500));


        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                northPanel.add(matchButton);
                matchButton.setPreferredSize(new Dimension(150, 150));
                
            }
        }

        // Create southPanel for the score section
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.setBackground(Color.CYAN);

        // Added the label to southPanel to represent score
        southPanel.add(this.label);

        // Added the two panels to the subPanel
        subPanel.add(northPanel);
        subPanel.add(southPanel);

    }

    public void setBoarSize(int size) {
        boardSize = size;
    }


    private void askUser() {
        Scanner scnr = new Scanner(System.in);
        String question = JOptionPane.showInputDialog("What size do you want the board to be? (Small, Medium, Large)");
        if(question.equalsIgnoreCase("small")) {
            setBoarSize(3);
        } else if(question.equalsIgnoreCase("medium")) {
            setBoarSize(4);
        } else if(question.equalsIgnoreCase("large")) {
            setBoarSize(5);
        } else if(question.equals(null)){
            System.out.println("Invalid input");
        }
    }


    /**
     * Reads the file and adds the words to the ArrayList
     */
    public void fileReader() {

        try {
        
        File file = new File("assets/words.txt");
        Scanner scnr = new Scanner(file);
        if(scnr.hasNextLine()) {
            cardWords.add(scnr.nextLine());
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JButton ButtonMaker(ArrayList<String> cardWords) {

        JButton button = new JButton();
        button.setPreferredSize(new Dimension(150,150));
        button.setBackground(Color.white);

        return button;
        


    }

}
