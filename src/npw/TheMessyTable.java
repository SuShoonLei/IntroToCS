package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;
import shapes.SSquare;

public class TheMessyTable {
    public static void main(String[] args) {

        double tableR = 40/2;
        SCircle table= new SCircle(tableR);

        double noteH = 8.5;
        double noteW = 11;
        SRectangle note = new SRectangle(noteH,noteW);

        double labH = 10.5;
        double labW = 14;
        SRectangle lab = new SRectangle(labH, labW);

        double canR = 1.25;
        SCircle  can = new SCircle(canR);
        SSquare coaster = can.circumscribingSquare();

        double plateR = 7/2;
        SCircle plate = new SCircle(plateR);

        double collectiveA = (2*note.area()) + lab.area() + (4*coaster.area()) + (4*plate.area());

        double result = table.area() - collectiveA;

        System.out.println("Area not covered on the table is " + result);
    }
}