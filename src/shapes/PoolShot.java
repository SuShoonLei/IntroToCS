package shapes;

import java.util.Scanner;

public class PoolShot {
    public static void main(String[] args) {
        int poolx = 88;
        int pooly = 44;
        SRectangle pool = new SRectangle(poolx,pooly);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x coordinate of the ball!");
        int x = sc.nextInt();
        System.out.println("Enter y coordinate of the ball!");
        int y = sc.nextInt();
        System.out.println("Enter k coordinate where the ball hit the table!");
        int k = sc.nextInt();

        SRectangle rec1 = new SRectangle(k-x,y);
        double diagonal = rec1.diagonal();

        double rec2Y = pooly;
        double rec2X = (rec1.height()/rec1.width())* rec2Y;
        SRectangle rec2 = new SRectangle(rec2X, rec2Y);

        double endpointX = rec2.height() +k ;
        if(endpointX > 87 && endpointX < 89){
            System.out.println("It went in!!");
        }else System.out.println("You missed!");
        System.out.println("Final location of the ball is "+ endpointX);
    }
}
