import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class board extends JFrame {

    JPanel panel = new JPanel();
    JButton buttonRestart = new JButton("Reset Board");
    ImageIcon cross = new ImageIcon("assets/cross.png");
    ImageIcon circle = new ImageIcon("assets/circle.png");
    int xScore = 0;
    int oScore = 0;
    JLabel labelScoreboard = new JLabel(" SCOREBOARD ");
    JLabel labelX = new JLabel("Player x: " + xScore);
    JLabel labelO = new JLabel("Player o: " + oScore);
    JLabel turnLabel = new JLabel();

    boolean player1 = true;

    JButton[][] buttons = new JButton[3][3];
    char[][] grid = new char[3][3];

    /**
     * Constructor
     */
    public board() {
        this.setTitle("Tic-Tac-Toe");
        this.setSize(500, 600);
        this.setResizable(false);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        turnShower();
        customLayout();

        this.setVisible(true);
    }

    /**
     * Does the layout for the game
     */
    private void customLayout() {

        // When the button is clicked it restarts the game
        buttonRestart.addActionListener(e -> restartBoard());

        // Created and utilized southPanel
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.CYAN);
        southPanel.setPreferredSize(new Dimension(500, 100));
        southPanel.add(buttonRestart);
        southPanel.add(turnLabel);
        southPanel.add(labelScoreboard);
        southPanel.add(labelO);
        southPanel.add(labelX);

        // Created and utilized northPanel
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(500, 500));
        northPanel.setLayout(new GridLayout(3, 3));

        // Added the panels to the main panel
        panel.setLayout(new FlowLayout());
        panel.add(northPanel);
        panel.add(southPanel);

        // Creats a 3x3 grid of buttons
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {

                // Creates a button and sets its properties
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(150, 150));
                button.setBackground(Color.WHITE);
                int row = i, col = j;

                // Creates a action listener to set variables for each button for game logic
                button.addActionListener(e -> {

                    // Checks if its empty, if not it does nothing to the button
                    if (grid[row][col] == '\0') {

                        // If player1 is true it sets the button to x since player1 is x and if false
                        // sets the button to o
                        if (player1) {
                            button.setIcon(cross);
                            grid[row][col] = 'x';
                        } else {
                            button.setIcon(circle);
                            grid[row][col] = 'o';
                        }

                        // Sets player1 to the opposite value for the next turn to be different
                        player1 = !player1;

                        // Shows turn
                        turnShower();

                        // Uses checkWin method to see who wins and prints out the winner and resets the
                        // board
                        if (checkWin(row, col)) {
                            if (!player1) {

                                xScore++;
                                labelX.setText("Player x: " + xScore);
                            } else {
                                oScore++;
                                labelO.setText("Player o: " + oScore);
                            }

                            JOptionPane.showMessageDialog(this, "Player " + (player1 ? "o" : "x") + " wins");

                            resetBoard();
                        }
                    }
                });

                // Adds button to the 2d Array and makes the grid all empty variables and adds
                // the buttons to the northpanel
                buttons[i][j] = button;
                grid[i][j] = '\0';
                northPanel.add(button);
            }
        }

    }

    /**
     * 
     * Checks all possible solutions to see if a win has happened
     * 
     * 
     * 
     * @param row x coordinate of the button
     * @param col y coordinate of the button
     * @return returns true if a win is detected
     */
    private boolean checkWin(int row, int col) {
        char symbol = grid[row][col];

        // Checks row
        if (grid[row][0] == symbol && grid[row][1] == symbol && grid[row][2] == symbol)
            return true;

        // Checks Column
        if (grid[0][col] == symbol && grid[1][col] == symbol && grid[2][col] == symbol)
            return true;

        if (row == col && grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol)
            return true;
        if (row + col == 2 && grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)
            return true;

        return false;

    }

    /**
     * Resets the board, changes everything to default value except the score
     * Used specifically for when someone wins the game so it can still be kept
     * playing
     */
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setIcon(null);
                grid[i][j] = '\0';

            }
        }
        player1 = true;
        turnShower();
    }

    /**
     * Changes everything to the default value even the score
     * Specfically meant for the reset button
     */
    private void restartBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setIcon(null);
                grid[i][j] = '\0';

            }
        }
        xScore = 0;
        oScore = 0;
        labelX.setText("Player x: " + xScore);
        labelO.setText("Player o: " + oScore);

        player1 = true;

    }

    /**
     * Sets the label to show whos turn it is
     */
    private void turnShower() {
        if (player1) {
            turnLabel.setText("Player x turn");
        } else {
            turnLabel.setText("Player o turn");
        }

    }

}
