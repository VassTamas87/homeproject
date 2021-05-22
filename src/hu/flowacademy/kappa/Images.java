package hu.flowacademy.kappa;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Images {

    Image img1 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/virag.png"));
    Image img2 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/harci.png"));
    Image img4 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/empty.png"));

    Image img5 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi.png"));
    Image img6 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi2.png"));
    Image img7 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi3.png"));
    Image img8 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi4.png"));
    Image img9 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi5.png"));
    Image img10 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi6.png"));
    Image img11 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi7.png"));
    Image img12 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi8.png"));
    Image img13 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi9.png"));
    Image img14 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi10.png"));
    Image img15 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi11.png"));
    Image img16 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi12.png"));
    Image img17 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi13.png"));
    Image img18 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi14.png"));
    Image img19 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi15.png"));
    Image img20 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi16.png"));
    Image img21 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi17.png"));
    Image img22 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi18.png"));
    Image img23 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi19.png"));
    Image img24 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi20.png"));
    Image img25 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi21.png"));
    Image img26 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi22.png"));
    Image img27 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi23.png"));
    Image img28 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi24.png"));
    Image img29 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi25.png"));
    Image img30 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi26.png"));
    Image img31 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi27.png"));
    Image img32 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi28.png"));
    Image img33 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi29.png"));
    Image img34 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi30.png"));
    Image img35 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi31.png"));
    Image img36 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi32.png"));
    Image img37 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi33.png"));
    Image img38 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi34.png"));
    Image img39 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi35.png"));
    Image img40 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi36.png"));
    Image img41 = ImageIO.read(new FileInputStream("/home/vasi/Git/homeproject/images/zombies/zombi37.png"));

    Image[] zombiePics = {img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18,
            img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30, img31, img32, img33, img34, img35,
            img36, img37, img38, img39, img40, img41};

    public Images() throws IOException {
    }

    public Image getImg2() {
        return img2;
    }

    public Image getImg4() {
        return img4;
    }

    public Image getImg1() {
        return img1;
    }
}


