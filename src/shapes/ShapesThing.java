package shapes;

public class  ShapesThing {
    public static void main(String[] args) {
        //Square
        SSquare square = new SSquare(400);
        System.out.println("square = " + square.toString());
        System.out.println("area of square = " + square.area());
        System.out.println(" perimeter of square = " + square.perimeter());
        System.out.println("diagonal of square + " + square.diagonal());

        //Circle
        SCircle disk = square.inscribingCircle();
        System.out.println("disk = " + disk.toString());
        System.out.println("area of disk = " + disk.area());
        System.out.println("perimeter of disk = " + disk.perimeter());

        //Diamond
        SSquare diamond = disk.inscribingSquare();
        System.out.println("diamond = " + diamond.toString());
        System.out.println("area of diamond = " + diamond.area());

        }

    }
