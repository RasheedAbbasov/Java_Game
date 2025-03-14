import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class board extends JFrame {

    JPanel panel = new JPanel();
    JButton buttonRestart = new JButton("Restart");
    ImageIcon cross = new ImageIcon("assets/cross.png");
    ImageIcon circle = new ImageIcon("assets/circle.png");
    int xScore = 0;
    int oScore = 0;
    JLabel label = new JLabel(" SCOREBOARD: X:" + xScore + " O:" + oScore);

    boolean player1 = true;

    JButton[][] buttons = new JButton[3][3];
    char[][] grid = new char[3][3];

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

        buttonRestart.addActionListener(e -> resetBoard());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.CYAN);
        southPanel.setPreferredSize(new Dimension(500, 100));
        southPanel.add(buttonRestart);
        southPanel.add(label);

        JPanel northPanel = new JPanel();
        // northPanel.setBackground(Color.GREEN);
        northPanel.setPreferredSize(new Dimension(500, 500));
        northPanel.setLayout(new GridLayout(3, 3));

        panel.setLayout(new FlowLayout());
        panel.add(northPanel);
        panel.add(southPanel);

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(150, 150));
                button.setBackground(Color.WHITE);
                int row = i, col = j;

                button.addActionListener(e -> {
                    if (grid[row][col] == '\0') {
                        if (player1) {
                            button.setIcon(cross);
                            grid[row][col] = 'x';
                        } else {
                            button.setIcon(circle);
                            grid[row][col] = 'o';
                        }
                        player1 = !player1;

                        if (checkWin(row, col)) {
                            JOptionPane.showMessageDialog(this, "Player " + (player1 ? "o" : "x") + " wins");
                            resetBoard();
                        }
                    }
                });

                buttons[i][j] = button;
                grid[i][j] = '\0';
                northPanel.add(button);
            }
        }

    }

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

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setIcon(null);
                grid[i][j] = '\0';

            }
        }

        player1 = true;
    }

}
