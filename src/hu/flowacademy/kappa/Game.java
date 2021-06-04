package hu.flowacademy.kappa;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;
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
    int movesLeft;
    boolean hard;
    int zombiTotal = 0;
    boolean isSound;
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/ingame.wav").getAbsoluteFile());
    Clip clip = AudioSystem.getClip();
    Sound sound2 = new Sound();
    Sound sound3 = new Sound();
    Sound sound5 = new Sound();
    Sound sound1 = new Sound();
    boolean pwIsActive;
    boolean pw2IsActive;
    boolean pw3IsActive;
    Sound sound6 = new Sound();
    JButton[] powers = new JButton[3];
    Sound sound7 = new Sound();

    Game(int difficulty, int moves, boolean sound) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (sound) {
            setSound(true);
        }
        if (moves == 6) {
            setHard(true);
            setZombiTotal(20);
        }
        if (!hard) {
            setZombiTotal(7);
        }
        if (isSound) {
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        setMovesLeft(moves);
        putFlowers("normal", 49);
        putFlowers("tropical", 15);
        putZombies(difficulty);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 45));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Day: " + dayCounter + "     Zombies Alive: " + zombiTotal + "     Moves Left: " + movesLeft);
        textfield.setOpaque(true);
        title_panel.setLayout(new FlowLayout());
        title_panel.setBounds(0, 0, 700, 100);
        button_panel.setLayout(new GridLayout(8, 8));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 3; i++) {
            powers[i] = new JButton();
            powers[i].setFocusable(false);
            powers[i].addActionListener(this);
            powers[i].setEnabled(false);
            powers[i].setBorderPainted(false);
            powers[i].setBackground(new Color(25, 25, 25));
            powers[i].setPreferredSize(new Dimension(200, 85));
        }
        powers[0].setIcon(new ImageIcon(images.pw1));
        powers[1].setIcon(new ImageIcon(images.pw2));
        powers[2].setIcon(new ImageIcon(images.pw3));

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
        title_panel.add(powers[0]);
        title_panel.add(powers[1]);
        title_panel.add(powers[2]);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        title_panel.setBackground(new Color(25, 25, 25));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == powers[0]) {
            if (!pwIsActive) {
                powers[0].setBackground(Color.RED);
                setPwIsActive(true);
                setPw2IsActive(false);
                powers[1].setBackground(new Color(25, 25, 25));
                setPw3IsActive(false);
                powers[2].setBackground(new Color(25, 25, 25));
            } else {
                powers[0].setBackground(new Color(25, 25, 25));
                setPwIsActive(false);
            }
        }
        if (actionEvent.getSource() == powers[1]) {
            if (!pw2IsActive) {
                powers[1].setBackground(Color.RED);
                setPw2IsActive(true);
                setPwIsActive(false);
                powers[0].setBackground(new Color(25, 25, 25));
                setPw3IsActive(false);
                powers[2].setBackground(new Color(25, 25, 25));
            } else {
                powers[1].setBackground(new Color(25, 25, 25));
                setPw2IsActive(false);
            }
        }
        if (actionEvent.getSource() == powers[2]) {
            if (!pw3IsActive) {
                powers[2].setBackground(Color.RED);
                setPw3IsActive(true);
                setPw2IsActive(false);
                powers[1].setBackground(new Color(25, 25, 25));
                setPwIsActive(false);
                powers[0].setBackground(new Color(25, 25, 25));
            } else {
                powers[2].setBackground(new Color(25, 25, 25));
                setPw3IsActive(false);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (actionEvent.getSource() == buttons[i][j]) {
                    if (pwIsActive) {
                        if (isSound) {
                            sound6.cherry();
                        }
                        powers[0].setEnabled(false);
                        powers[0].setBackground(new Color(25, 25, 25));
                        setPwIsActive(false);
                    }
                    if (pw2IsActive) {
                        if (isSound) {
                            sound7.floop();
                        }
                        powers[1].setEnabled(false);
                        powers[1].setBackground(new Color(25, 25, 25));
                        setPw2IsActive(false);
                    }
                    if (pw3IsActive) {
                        if (isSound) {
                            sound6.cherry();
                        }
                        powers[2].setEnabled(false);
                        powers[2].setBackground(new Color(25, 25, 25));
                        setPw3IsActive(false);
                    }
                    if (validMove(i, j)) {
                        movePlayer(i, j);
                        movesLeft--;
                        if (isSound) {
                            if ((!hard && (movesLeft == 5 || movesLeft == 2)) || (hard && movesLeft == 3)) {
                                sound5.select();
                            }
                        }
                        if (movesLeft == 0) {
                            if (hard) {
                                movesLeft = 6;
                            }
                            if (!hard) {
                                movesLeft = 7;
                            }
                            dayCounter++;
                            if (dayCounter > 1) {
                                enableButtons();
                            }
                            gettingOlder();
                            zombiesMove();
                            bornZombies();
                            if (isSound) {
                                sound1.rooster();
                            }
                        }
                        textfield.setText("Day: " + dayCounter + "     Zombies Alive: " + zombiTotal + "     Moves Left: " + movesLeft);
                        checkEndGame();
                    }
                }
            }
        }
    }

    public void setPwIsActive(boolean pwIsActive) {
        this.pwIsActive = pwIsActive;
    }

    public void setPw2IsActive(boolean pw2IsActive) {
        this.pw2IsActive = pw2IsActive;
    }

    public void setPw3IsActive(boolean pw3IsActive) {
        this.pw3IsActive = pw3IsActive;
    }

    public void setSound(boolean sound) {
        isSound = sound;
    }

    public void setZombiTotal(int zombiTotal) {
        this.zombiTotal = zombiTotal;
    }

    public void setHard(boolean hard) {
        this.hard = hard;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public void enableButtons() {
        powers[0].setEnabled(true);
        powers[1].setEnabled(true);
        powers[2].setEnabled(true);
    }

    public void putFlowers(String type, int limit) {
        int counter = 0;
        while (counter < limit) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y] == null) {
                if (type.equals("normal")) {
                    map[x][y] = new Normal(x, y);
                }
                if (type.equals("tropical")) {
                    map[x][y] = new Tropical(x, y);
                }
                counter++;
            }
        }
    }

    public void putZombies(int difficulty) {
        int counter = 0;
        while (counter < difficulty) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y].getZombiList().size() == 0) {
                map[x][y].getZombiList().add(new Zombi());
                counter++;
            }
        }
    }

    public void setProperties(int i, int j) {
        buttons[i][j].setText("<html>" + map[i][j].getType() + "<br/>" + "Hp: " + map[i][j].getHp()
                + "<br/>" + "Z_num:" + map[i][j].getZombiList().size() + "</html>");
    }

    public void setZombieProperties(int i, int j) {
        buttons[i][j].setText("Z_num:" + map[i][j].getZombiList().size());
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

    public void setEmptyField(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(images.getImg4()));
        buttons[i][j].setText("");
    }

    public void setMapElements(int i, int j) {
        if (map[i][j].getZombiList().size() > 0) {
            setZombiePic(i, j);
        } else if (map[i][j].getType().equals("Sunflower")) {
            buttons[i][j].setIcon(new ImageIcon(images.getImg1()));
        } else if (map[i][j].getType().equals("Gatling Pea")) {
            buttons[i][j].setIcon(new ImageIcon(images.getImg2()));
        }
        buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
        setProperties(i, j);
    }

    public void movePlayer(int i, int j) {
        buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 14));
        zombiTotal -= map[i][j].getZombiList().size();
        map[i][j].getZombiList().clear();
        if (map[i][j].getHp() > 0) {
            setMapElements(i, j);
            setProperties(i, j);
        }
        if (map[i][j].getHp() <= 0) {
            setEmptyField(i, j);
        }
        buttons[player.getX()][player.getY()].setBackground(new JButton().getBackground());
        player.setX(i);
        player.setY(j);
        setGreenField();
    }

    public void whereTo(int i, int j, Zombi temp) {
        int[][] possibleMoves = new int[8][8];
        int k = 0;
        for (int n = i - 1; n < i + 2; n++) {
            for (int m = j - 1; m < j + 2; m++) {
                if ((n >= 0 && n < 8 && m >= 0 && m < 8) && (map[i][j] != map[n][m]) && (map[n][m].getHp() > 0)) {
                    possibleMoves[k][0] = n;
                    possibleMoves[k][1] = m;
                    k++;
                }
            }
        }
        if (k > 0) {
            transferZombie("normal", possibleMoves, k, temp);
        } else {
            moveToEmptyField(i, j, temp);
        }
    }

    public void bornZombies() {
        int[][] zombies = new int[63][63];
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].getZombiList().size() > 0) {
                    zombies[k][0] = i;
                    zombies[k][1] = j;
                    k++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            whereToBorn(zombies[i][0], zombies[i][1]);
        }
    }

    public void whereToBorn(int i, int j) {
        int k = 0;
        int[][] possibleMoves = new int[8][8];
        for (int n = i - 1; n < i + 2; n++) {
            for (int m = j - 1; m < j + 2; m++) {
                if ((n >= 0 && n < 8 && m >= 0 && m < 8) && (map[i][j] != map[n][m]) && (map[n][m].getHp() > 0) && (map[n][m].getZombiList().size() < 1)) {
                    possibleMoves[k][0] = n;
                    possibleMoves[k][1] = m;
                    k++;
                }
            }
        }

        int size = map[i][j].getZombiList().size();
        if (k > 0) {
            for (int l = 0; l < map[i][j].getZombiList().size(); l++) {
                int possI = (int) Math.floor(Math.random() * k);
                map[possibleMoves[possI][0]][possibleMoves[possI][1]].getZombiList().add(new Zombi());
                zombiTotal++;
                setMapElements(possibleMoves[possI][0], possibleMoves[possI][1]);
                setProperties(possibleMoves[possI][0], possibleMoves[possI][1]);
            }
        } else {
            for (int o = 0; o < size; o++) {
                map[i][j].getZombiList().add(new Zombi());
                zombiTotal++;
                if (map[i][j].getHp() > 0) {
                    setProperties(i, j);
                } else {
                    setZombieProperties(i, j);
                }
            }
        }
    }

    public void transferZombie(String type, int[][] arr, int k, Zombi temp) {
        int possI = (int) Math.floor(Math.random() * k);
        map[arr[possI][0]][arr[possI][1]].getZombiList().add(temp);
        setZombiePic(arr[possI][0], arr[possI][1]);

        if (type.equals("normal")) {
            setProperties(arr[possI][0], arr[possI][1]);
        }
        if (type.equals("empty")) {
            setZombieProperties(arr[possI][0], arr[possI][1]);
        }
    }

    public boolean inspectNeighbors(int i, int j) {
        for (int n = i - 1; n < i + 2; n++) {
            for (int m = j - 1; m < j + 2; m++) {
                if ((n >= 0 && n < 8 && m >= 0 && m < 8) && (map[i][j] != map[n][m]) && (map[n][m].getHp() > 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveToEmptyField(int i, int j, Zombi temp) {
        int[][] possibleMoves = new int[8][8];
        int[][] betterMoves = new int[8][8];
        int k = 0;
        int l = 0;
        for (int n = i - 1; n < i + 2; n++) {
            for (int m = j - 1; m < j + 2; m++) {
                if ((n >= 0 && n < 8 && m >= 0 && m < 8) && (map[i][j] != map[n][m])) {
                    possibleMoves[k][0] = n;
                    possibleMoves[k][1] = m;
                    k++;
                    if (inspectNeighbors(n, m)) {
                        betterMoves[l][0] = n;
                        betterMoves[l][1] = m;
                        l++;
                    }
                }
            }
        }
        if (l > 0) {
            transferZombie("empty", betterMoves, l, temp);
        } else {
            transferZombie("empty", possibleMoves, k, temp);
        }
    }

    public void zombiesMove() {
        int[][] zombiesNeedToMove = new int[100][100];
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].getHp() <= 0 && map[i][j].getZombiList().size() > 0) {
                    zombiesNeedToMove[k][0] = i;
                    zombiesNeedToMove[k][1] = j;
                    k++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            setEmptyField(zombiesNeedToMove[i][0], zombiesNeedToMove[i][1]);
            List<Zombi> temp = new ArrayList<>(map[zombiesNeedToMove[i][0]][zombiesNeedToMove[i][1]].getZombiList());
            map[zombiesNeedToMove[i][0]][zombiesNeedToMove[i][1]].getZombiList().clear();
            for (Zombi zombi : temp) {
                whereTo(zombiesNeedToMove[i][0], zombiesNeedToMove[i][1], zombi);
            }
        }
    }

    public void checkEndGame() {
        int hpCounter = 0;
        int zCounter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].getHp() > 0) {
                    hpCounter++;
                }
                zCounter += map[i][j].getZombiList().size();
            }
        }
        if (hpCounter == 0) {
            end("GAME OVER", "red");
        }
        if (zCounter <= 0) {
            end("STAGE COMPLETED", "green");
        }
    }

    public void end(String end, String color) {
        clip.stop();
        if (color.equals("green")) {
            if (isSound) {
                sound2.win();
            }
        }
        if (color.equals("red")) {
            if (isSound) {
                sound3.lose();
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setBackground(new JButton().getBackground());
                if (color.equals("red")) {
                    buttons[i][j].setBackground(Color.RED);
                }
                if (color.equals("green")) {
                    buttons[i][j].setBackground(Color.GREEN);
                }
                buttons[i][j].setEnabled(false);
                textfield.setText(end);
                title_panel.remove(powers[0]);
                title_panel.remove(powers[1]);
                title_panel.remove(powers[2]);
            }
        }
    }

    public void flowerAttacking(int i, int j) {
        for (int k = 0; k < map[i][j].getZombiList().size(); k++) {
            map[i][j].getZombiList().get(k).setHp(map[i][j].getZombiList().get(k).getHp() - (int) Math.floor(Math.random() * 6) + 1);
            if (map[i][j].getZombiList().get(k).getHp() <= 0) {
                map[i][j].getZombiList().remove(k);
                zombiTotal--;
                k--;
                setMapElements(i, j);
                setProperties(i, j);
            }
        }
        if (map[i][j].getZombiList().size() < 1 && map[i][j].getHp() < 1) {
            setEmptyField(i, j);
        }
    }

    public void zombieAttack(int i, int j) {
        map[i][j].setHp(map[i][j].getHp() - (map[i][j].getZombiList().size() * 2));
        for (int n = 0; n < map[i][j].getZombiList().size(); n++) {
            if ((map[i][j].getZombiList().get(n).getHp() < 3) && (map[i][j].getZombiList().get(n).getHp() > 0)) {
                map[i][j].getZombiList().get(n).setHp(map[i][j].getZombiList().get(n).getHp() + 3);
            }
            if (map[i][j].getZombiList().get(n).getHp() >= 3) {
                map[i][j].getZombiList().get(n).setHp(6);
            }
        }
    }

    public void zombieStarving(int i, int j) {
        for (int m = 0; m < map[i][j].getZombiList().size(); m++) {
            map[i][j].getZombiList().get(m).setHp(map[i][j].getZombiList().get(m).getHp() - 3);
            if (map[i][j].getZombiList().get(m).getHp() <= 0) {
                map[i][j].getZombiList().remove(m);
                zombiTotal--;
                m--;
                setZombieProperties(i, j);
            }
        }
    }

    public void gettingOlder() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j].setAge(map[i][j].getAge() + 1);
                if (map[i][j].getZombiList().size() > 0 && map[i][j].getHp() > 0) {
                    zombieAttack(i, j);
                    if (map[i][j].getType().equals("Gatling Pea")) {
                        flowerAttacking(i, j);
                    }
                } else if (map[i][j].getZombiList().size() > 0 && map[i][j].getHp() <= 0) {
                    zombieStarving(i, j);
                    if (map[i][j].getZombiList().size() <= 0 && map[i][j].getHp() <= 0) {
                        setEmptyField(i, j);
                    }
                    if (map[i][j].getZombiList().size() <= 0) {
                        setEmptyField(i, j);
                    }
                }
                if (map[i][j].getHp() > 0) {
                    setProperties(i, j);
                }
            }
        }
    }
}


