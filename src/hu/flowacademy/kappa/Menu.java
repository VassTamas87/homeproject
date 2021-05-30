package hu.flowacademy.kappa;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class Menu extends JPanel implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    Image menupic = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/menupic.png"));
    JButton[] buttons = new JButton[3];

    Menu() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(25, 25, 25));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 150));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Kertész és virágok");
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        button_panel.setBounds(0, 0, 800, 100);
        button_panel.setBackground(new Color(50, 50, 50));
        JLabel picLabel = new JLabel(new ImageIcon(menupic));
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        button_panel.setLayout(new GridLayout(3, 1, 0, 0));
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            int j = i;
            buttons[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttons[j].setBackground(Color.GREEN);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttons[j].setBackground(UIManager.getColor("control"));
                }
            });
        }
        buttons[0].setText("Normal");
        buttons[1].setText("Hard");
        buttons[2].setText("Quit");
        frame.add(button_panel, BorderLayout.CENTER);
        frame.add(picLabel, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttons[0]) {
            try {
                frame.setVisible(false);
                Game game = new Game(7, 12);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == buttons[1]) {
            try {
                frame.setVisible(false);
                Game game = new Game(20, 6);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == buttons[2]) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}