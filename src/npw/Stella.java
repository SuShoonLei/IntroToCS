package npw;

import painter.SPainter;
import shapes.SSquare;

import java.awt.*;
import java.util.Scanner;

public class Stella {
    public static void main(String[] args) {
        System.out.printf("Enter number of squares: ");
        Scanner sc = new Scanner(System.in);
        int noOfSq = sc.nextInt();

        Color first = randomColor();
        Color second = randomColor();
        Color third = randomColor();

        SPainter MP = new SPainter(800,800);
        SSquare sq = new SSquare(700);

        for(int i= 0; i<noOfSq; i++)
        {
            if (i%3 == 0){MP.setColor(first);}

            else if (i%3 == 1) {MP.setColor(second);}

            else {MP.setColor(third);}

            MP.paint(sq);
            int j = 1400/ ((2*noOfSq)-1);
            sq.shrink(j);
        }

    }
    private static Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color(rv, gv, bv);
    }
}