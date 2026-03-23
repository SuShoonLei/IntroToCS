package shapes;

public class D8WhiteSpace {
    public static void main(String[] args) {
        double pipsR = (double) 3 /2;
        SCircle pips = new SCircle(pipsR);

        int noOfPips = 1+2+3+4+5+6+7+8;
        double pipsA = noOfPips * pips.area();

        double triangleS = 16;
        STriangle side = new STriangle(triangleS);
        System.out.println(side.area()+ " is t area"+ side.sideA() + side.sideB()+ side.sideC());

        int noOfSide = 8;
        double totalA = noOfSide * side.area();

        double notCA = totalA - pipsA;

        System.out.println("Total area not covered by pips is " + notCA);
    }
}
