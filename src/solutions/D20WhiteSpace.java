package solutions;

import shapes.SCircle;
import shapes.STriangle;

public class D20WhiteSpace {
    public static void main(String[] args) {
        double pipsR = (double) 0.125 /2;
        SCircle pips = new SCircle(pipsR);

        int noOfPips = 1+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19+20;
        double pipsA = noOfPips * pips.area();

        double triangleS = 12.27;
        STriangle side = new STriangle(triangleS);
        System.out.println(side.area()+ " is t area"+ side.sideA() + side.sideB()+ side.sideC());

        int noOfSide = 20;
        double totalA = noOfSide * side.area();

        double notCA = totalA - pipsA;

        System.out.println("Total area not covered by pips is " + notCA);
    }
}
