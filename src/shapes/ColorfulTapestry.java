package shapes;

import painter.SPainter;



public class ColorfulTapestry {
    public static void main(String[] args) {
        double Bside = 24.3;
        SSquare Bblue = new SSquare(Bside);

        double r1 = (Bside/2) - (3.1+3.1);
        SCircle cr1 = new SCircle(r1);

        SSquare pink = cr1.inscribingSquare();

        double Sside = 1.7;
        SSquare Sblue = new SSquare(Sside);
        SCircle cr = Sblue.inscribingCircle();



        double blueA = (Bblue.area()-pink.area()) + (Sblue.area()-cr.area());
        System.out.println("The area of the blue space is " + blueA );
    }
}