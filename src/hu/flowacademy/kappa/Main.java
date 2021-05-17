package hu.flowacademy.kappa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map terkep = new Map(8, 8);
        //terkep.clearMap();
        terkep.putFlowers();
        terkep.putTropical();
        terkep.putPlayer();
        terkep.drawMap();
        String str = scan.nextLine();

        while (!str.equals("KILÉP")) {
            terkep.doCommand(str);
            terkep.drawMap();
            str = scan.nextLine();
        }
    }
}