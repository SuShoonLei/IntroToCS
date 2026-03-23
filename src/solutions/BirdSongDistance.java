package solutions;

import shapes.SRectangle;

import java.util.Scanner;

public class BirdSongDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("What is the height of the house? ");
        int Hheight = sc.nextInt();

        System.out.printf("What is the width of the house? ");
        int Hwidth = sc.nextInt();

        System.out.printf("How many number of houses are there? ");
        int nrOfHouse = sc.nextInt();

//        int asTheBirdFlies =

        SRectangle key = new SRectangle(Hheight, Hwidth*nrOfHouse);

        double distance = key.diagonal();
        System.out.println(distance);
    }
}
