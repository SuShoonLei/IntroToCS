package npw;

import java.util.Scanner;

public class CaveMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the width of the game map:");
        int gWidth = sc.nextInt();
        System.out.printf("Enter the width of the cave (must be less than the game map width):");
        int cWidth = sc.nextInt();
        int star = gWidth-cWidth;

        for (int i = 0; i < star; i++){
            drawOneRow(i, cWidth, gWidth);
            System.out.println();
        }
        // Cave moving left...!
        for (int i = star; i >= 0; i--){
            drawOneRow(i, cWidth, gWidth);
            System.out.println();
        }
    }

    private static void drawOneRow(int i, int cWidth, int gWidth) {
        for (int j= 0 ; j < i ; j++){
            System.out.printf("*");
        }
        for (int k= 0 ; k < cWidth ; k++){
            System.out.printf(" ");
        }
        for (int l= 0 ; l < (gWidth-(cWidth+i)) ; l++){
            System.out.printf("*");
        }
    }
}
