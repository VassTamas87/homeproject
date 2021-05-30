package hu.flowacademy.kappa;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class Menu implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    Image menupic = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/menupic.png"));
    JButton[] buttons = new JButton[2];

    Menu() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 150));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Kertész és virágok");
        textfield.setOpaque(true);
        // title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        // button_panel.setLayout(new GridLayout(8, 8));
        button_panel.setBackground(new Color(150, 150, 150));


        JLabel picLabel = new JLabel(new ImageIcon(menupic), JLabel.LEFT);
        frame.add(picLabel);

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);

        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 14));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setHorizontalAlignment(SwingConstants.RIGHT);
            buttons[i].setPreferredSize(new Dimension(100, 50));
            buttons[i].setText("Start");
        }


        frame.add(button_panel);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttons[0]) {
            try {
                frame.setVisible(false);
                Game game = new Game();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}