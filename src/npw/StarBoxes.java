package npw;

import java.util.Scanner;

public class StarBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Number of rows? ");
        int nrOfRows = sc.nextInt();
        System.out.printf("Number of columns? ");
        int nrOfColumns = sc.nextInt();
        drawStarBox(nrOfRows,nrOfColumns);
    }

    public static void drawStarBox(int nrOfRows , int nrOfColumns ) {
        int i = 0;
        while ( i < nrOfRows ) {
            if ( i == 0 ) {
                drawStarBox(nrOfColumns);
            }
            else if ( i == nrOfRows - 1 ) {
                drawStarBox(nrOfColumns);
            }
            else {
                drawOneRow(nrOfColumns);
            }
            i = i + 1 ;
        }
    }

    private static void drawStarBox(int nrOfColumns) {
        for ( int i = 0 ; i < nrOfColumns ; i++ ){
            System.out.printf("*");
        }
        System.out.println();
    }
    private static void drawOneRow ( int nrOfColumns ) {
        System.out.printf("*");
        for ( int i = 0; i <nrOfColumns-2 ; i++ ) {
            System.out.printf(" ");
        }
        System.out.println("*");

    }
}
