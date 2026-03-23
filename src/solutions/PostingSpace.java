package solutions;

import shapes.SCircle;
import shapes.SRectangle;
import shapes.SSquare;

public class PostingSpace {
    public static void main(String[] args) {
        SRectangle bboard = new SRectangle(60, 48);
        SRectangle flyer = new SRectangle(8.5, 11);
        SRectangle anotice = new SRectangle(8.5, 11);
        SRectangle poster = new SRectangle(24, 36);
        SCircle sticker = new SCircle(2.3);
        SSquare backing = sticker.circumscribingSquare();


        SSquare paper = new SSquare(8);
        SCircle CutOut = paper.inscribingCircle();

        double notcovered = bboard.area() - (flyer.area() * 7 + anotice.area() * 2 + poster.area() + sticker.area() * 10 + backing.area() + (paper.area() - CutOut.area() * 3));
        System.out.println(" The area of Posting Space which is not covered " + notcovered);
    }
}

