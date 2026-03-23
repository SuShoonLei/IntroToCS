package expressions;

public class ExpressionsThing {
    public static void main(String[] args) {
        double one = 3.14 * 5 + 5;
        System.out.println("one = " + one);

        double two = 3.14 * (5 + 5);
        System.out.println("two = " + two);

        double three = (3.14 * (5 + 5));
        System.out.println("three = " + three);

        int four = (5 * 6);
        System.out.println("four = " + four);

        double five = (((double) 1 /2) * 55);
        System.out.println("five = " + five);

        double six = (((double) 1/3) * 65);
        System.out.println("six = " + six);

        double seven = ((0.5 * 55) + (((double) 1/3) * 65));
        System.out.println("seven = " + seven);

        double PI = 3.14;
        double R = 11.3;
        double eight = PI * ( R * R );
        System.out.println("eight = " + eight);

        double S = 27.7;
        double nine = ( S * S);
        System.out.println("nine = " + nine);

        double ten = ( R / S );
        System.out.println("ten = " + ten);

        double eleven = (((double) 17/100) * 243.5);
        System.out.println("eleven = " + eleven);

        int twelve = ( 3 / 3);
        System.out.println("twelve = " + twelve);

        int thirteen = 7 - ( 4 + 2);
        System.out.println("thirteen = " + thirteen);

        int fourteen = (9 - (7 + 1) + 3);
        System.out.println("fourteen = " + fourteen);

        int fifteen = ( 6 + 4) / (8 / (2 + 2));
        System.out.println("fifteen = " + fifteen);
    }
}