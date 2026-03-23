package npw;

import painter.SPainter;
import shapes.SSquare;

import java.awt.*;
import java.util.Scanner;

public class PinWheel {
    public static void main(String[] args) {
        System.out.printf("Enter number of squares: ");
        Scanner sc = new Scanner(System.in);
        int noOfSq = sc.nextInt();

        Color first = randomColor();
        Color second = randomColor();

        SPainter MP = new SPainter(600,600);
        SSquare sq = new SSquare(400);

        int rotation = 90/noOfSq;

        for(int i= 0; i<noOfSq; i++){
            if (i%2 == 0){MP.setColor(first);}
            else {MP.setColor(second);}

            MP.paint(sq);
            MP.tr(rotation);
        }

    }
    private static Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color(rv, gv, bv);
    }
}
