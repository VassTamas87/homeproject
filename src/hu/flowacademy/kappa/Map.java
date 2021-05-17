package hu.flowacademy.kappa;

import java.util.Arrays;

public class Map {

    private Object[][] map;
    private Player player;

    public Map(int a, int b) {
        this.map = new Object[a][b];
        this.player = new Player(a, b);
        //map[0][0] = '$';
    }

//    public void clearMap() {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (map[i][j] == null)
//                    map[i][j] = ' ';
//            }
//        }
//        map[0][0] = '$';
//    }

    public void drawMap() {
        for (Object[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void putFlowers() {
        int counter = 0;
        while (counter < 49) {
            int x = (int) Math.floor(Math.random() * 8);
            int y = (int) Math.floor(Math.random() * 8);
            if (map[x][y] == null) {
                map[x][y] = new Flower(x, y);
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

    public void putPlayer() {

        Flower start = (Flower) map[0][0];
        start.setPlayerPresent(true);
    }

    public void doCommand(String comm) {
        String str = comm;

        if (str.equals("LE")) {
            player.move("LE");
            Flower temp = (Flower) map[player.getX()][player.getY()];
            temp.setPlayerPresent(true);
            Flower temp2 = (Flower) map[player.getX() - 1][player.getY()];
            temp2.setPlayerPresent(false);
        }
        if (str.equals("FEL")) {
            player.move("FEL");
            Flower temp = (Flower) map[player.getX()][player.getY()];
            temp.setPlayerPresent(true);
            Flower temp2 = (Flower) map[player.getX() + 1][player.getY()];
            temp2.setPlayerPresent(false);
        }
        if (str.equals("JOBBRA")) {
            player.move("JOBBRA");
            Flower temp = (Flower) map[player.getX()][player.getY()];
            temp.setPlayerPresent(true);
            Flower temp2 = (Flower) map[player.getX()][player.getY() - 1];
            temp2.setPlayerPresent(false);
        }
        if (str.equals("BALRA")) {
            player.move("BALRA");
            Flower temp = (Flower) map[player.getX()][player.getY()];
            temp.setPlayerPresent(true);
            Flower temp2 = (Flower) map[player.getX()][player.getY() + 1];
            temp2.setPlayerPresent(false);
        }
    }


    //    public void doCommand(String comm) {
//        String str = comm;
//
//        if (str.equals("LE")) {
//            player.move("LE");
//            map[player.getX()][player.getY()] = '$';
//            map[player.getX() - 1][player.getY()] = ' ';
//        }
//        if (str.equals("FEL")) {
//            player.move("FEL");
//            map[player.getX()][player.getY()] = '$';
//            map[player.getX() + 1][player.getY()] = ' ';
//        }
//        if (str.equals("JOBBRA")) {
//            player.move("JOBBRA");
//            map[player.getX()][player.getY()] = '$';
//            map[player.getX()][player.getY() - 1] = ' ';
//        }
//        if (str.equals("BALRA")) {
//            player.move("BALRA");
//            map[player.getX()][player.getY()] = '$';
//            map[player.getX()][player.getY() + 1] = ' ';
//        }
//    }
}


