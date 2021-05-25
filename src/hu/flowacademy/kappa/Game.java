package hu.flowacademy.kappa;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Game implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] buttons = new JButton[8][8];
    Images images = new Images();
    Flower[][] map = new Flower[8][8];
    Player player = new Player(8, 8);
    int dayCounter = 1;
    int movesLeft = 12;

    Game() throws IOException {
        putFlowers();
        putTropical();
        putZombies();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Kertész és virágok" + " --- Day: " + dayCounter + "/Moves Left: " + movesLeft);
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        button_panel.setLayout(new GridLayout(8, 8));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                button_panel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 14));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                setMapElements(i, j);
            }
            setGreenField();
        }
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (actionEvent.getSource() == buttons[i][j]) {
                    if (validMove(i, j)) {
                        movePlayer(i, j);
                        movesLeft--;
                        if (movesLeft == 0) {
                            movesLeft = 12;
                            dayCounter++;
                            gettingOlder();
                            zombiesMove();
                        }
                        textfield.setText("Kertész és virágok" + " --- Day: " + dayCounter + "/Moves Left: " + movesLeft);
                    }
                }
            }
        }
    }

    public void putFlowers() {
        int counter = 0;
        while (counter < 49) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y] == null) {
                map[x][y] = new Normal(x, y);
                counter++;
            }
        }
    }

    public void putTropical() {
        int counter = 0;
        while (counter < 15) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y] == null) {
                map[x][y] = new Tropical(x, y);
                counter++;
            }
        }
    }

    public void putZombies() {
        int counter = 0;
        while (counter < 1) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y].getZombiList().size() == 0) {
                map[x][y].getZombiList().add(new Zombi());
                counter++;
            }
        }
    }

    public void setProperties(int i, int j) {
        buttons[i][j].setText("<html>" + map[i][j].getType() + "<br/>" + "Hp: " + map[i][j].getHp() + "<br/>" + "Age: " + map[i][j].getAge() + "<br/>" + "Z_num:" + map[i][j].getZombiList().size() + "</html>");
    }

    public void setGreenField() {
        buttons[player.getX()][player.getY()].setBackground(Color.GREEN);
    }

    public boolean validMove(int i, int j) {
        return player.getX() == i && player.getY() == j
                || player.getX() == i - 1 && player.getY() == j
                || player.getX() == i + 1 && player.getY() == j
                || player.getX() == i && player.getY() == j - 1
                || player.getX() == i && player.getY() == j + 1;
    }

    public void setZombiePic(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(images.zombiePics[(int) Math.floor(Math.random() * images.zombiePics.length)]));
    }

    public void setMapElements(int i, int j) {
        if (map[i][j].getType().equals("Sunflower")) {
            if (map[i][j].getZombiList().size() > 0) {
                setZombiePic(i, j);
            } else {
                buttons[i][j].setIcon(new ImageIcon(images.getImg1()));
            }
            buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
            setProperties(i, j);
        }
        if (map[i][j].getType().equals("Gatling Pea")) {
            if (map[i][j].getZombiList().size() > 0) {
                setZombiePic(i, j);
            } else {
                buttons[i][j].setIcon(new ImageIcon(images.getImg2()));
            }
            buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
            setProperties(i, j);
        }
    }

    public void movePlayer(int i, int j) {
        buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 14));
        map[i][j].getZombiList().clear();
        if (map[i][j].getHp() > 0) {
            setMapElements(i, j);
            setProperties(i, j);
        }
        buttons[player.getX()][player.getY()].setBackground(new JButton().getBackground());
        player.setX(i);
        player.setY(j);
        setGreenField();
    }

    public void whereTo(int i, int j, List<Zombi> temp) {
        int[][] possibleMoves = new int[8][8];
        int k = 0;
        for (int n = i - 1; n < i + 2; n++) {
            for (int m = j - 1; m < j + 2; m++) {
                if ((n >= 0 && n < 8 && m >= 0 && m < 8) && map[i][j] != map[n][m] && map[n][m].getHp() > 0) {
                    possibleMoves[k][0] = n;
                    possibleMoves[k][1] = m;
                    k++;
                }
            }
        }
        int possI = (int) Math.floor(Math.random() * k);
        map[possibleMoves[possI][0]][possibleMoves[possI][1]].getZombiList().addAll(temp);
        setZombiePic(possibleMoves[possI][0], possibleMoves[possI][1]);
        setProperties(possibleMoves[possI][0], possibleMoves[possI][1]);
    }

    public void zombiesMove() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].getHp() <= 0 && map[i][j].getZombiList().size() > 0) {
                    buttons[i][j].setIcon(new ImageIcon(images.getImg4()));
                    buttons[i][j].setText("");
                    List<Zombi> temp = new ArrayList<>(map[i][j].getZombiList());
                    map[i][j].getZombiList().clear();
                    whereTo(i, j, temp);
                    if (map[i][j].getHp() > 0) {
                        setProperties(i, j);
                    }
                }
            }
        }
    }

    public void gettingOlder() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j].setAge(map[i][j].getAge() + 1);
                map[i][j].setHp(map[i][j].getHp() - (map[i][j].getZombiList().size() * 2));
                if (map[i][j].getHp() > 0) {
                    setProperties(i, j);
                }
            }
        }
    }
}