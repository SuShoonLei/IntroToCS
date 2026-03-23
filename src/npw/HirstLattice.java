/*
 * A program to paint an artistic representation of entropy in the NPW.
 */
package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class HirstLattice {

    private void paintTheImage(){

        // determine the canvas dimensions
        int canvasHeight = getNumber("Canvas height");
        int canvasWidth = getNumber("Canvas width");

        // set up a circle (imagining a sphere-packing problem :)
        //   and get the square inscribing the circle so that the lattice
        //   will be just perfect.
        int radius = getNumber("Diamond scale");
        SCircle invisibleCircle = new SCircle(radius);
        SSquare sq = invisibleCircle.inscribingSquare();

        // instantiate the painter and canvas
        SPainter cassatt = new SPainter("Hirst Lattice", canvasWidth, canvasHeight);

        // frame the canvas: we want a 10 unit frame of white on all sides.
        int frameDepth = 10;

        // compute the number of columns needed
        // working canvas width / diameter of invisibleCircle
        int totalNumberOfColumns = (int) ((canvasWidth-(2*frameDepth))/invisibleCircle.diameter());

        // check the work and adjust horizontal frameDepth as needed.
        int horizFrameDepth = (int) ((canvasWidth - (totalNumberOfColumns * invisibleCircle.diameter())) / 2);

        // compute the number of squares needed per column
        int numberOfSquaresPerColumn = (int) ((canvasHeight - 2*frameDepth)/invisibleCircle.diameter());

        // check the work and adjust the vertical frameDepth as needed
        int vertFrameDepth = (int) ((canvasHeight - (numberOfSquaresPerColumn * invisibleCircle.diameter())) / 2);

        // move the painter to the top left of the working canvas area
        //    remember, painter began at center of canvas
        cassatt.mfd(0.5*canvasHeight-vertFrameDepth);
        cassatt.mlt(0.5*canvasWidth-horizFrameDepth);

        // center the painter over the first column
        cassatt.mrt(invisibleCircle.radius());

        // track the number of columns painted
        int colNumber = 0;

        // introduce a chaos factor to change things up
        double chaosFactor = 0;

        while (colNumber < totalNumberOfColumns){
            // set the color for the column
            cassatt.setColor(randomColor());

            // paint a column
            paintOneColumn(cassatt,sq,numberOfSquaresPerColumn, chaosFactor);

            // center the painter over the next column
            cassatt.mrt(invisibleCircle.diameter());
            colNumber = colNumber + 1;
//            chaosFactor = (1.0/totalNumberOfColumns)*colNumber;
        }
    }

    private Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color(rv, gv, bv);
    }

    private void paintOneColumn(SPainter cassatt, SSquare sq, int numberOfSquaresPerColumn, double chaosFactor) {
        // move down enough to paint the first square
        cassatt.mbk(sq.diagonal()*0.5);

        // track the amount of distance travelled
        double distanceTraveled = sq.diagonal()*0.5;

        // track the number of squares that get painted in the column
        int squareNumber = 0;
        while(squareNumber < numberOfSquaresPerColumn){

            // paint a square, but as a diamond
            paintOneDiamond(cassatt,sq,chaosFactor);

            // move down
            cassatt.mbk(sq.diagonal());

            // track distance covered
            distanceTraveled = distanceTraveled + sq.diagonal();

            // track number of squares painted so far
            squareNumber = squareNumber + 1;
        }

        // make sure the painter is invariant wrt position
        cassatt.mfd(distanceTraveled);
    }

    private void paintOneDiamond(SPainter cassatt, SSquare sq, double chaosFactor) {

//         set the default values
//        double origSquareSide = sq.side();
//        double rotationOffset = 0;
//        double offsetDirection = 0;
//        double offsetDistance = 0;
//
//        // when the chaosFactor is high enough, redefine the key values (sometimes)
//        if (chaosFactor > 0.3){
//            // flip the coin!
//            double probability = Math.random();
//
//            // for a heads, offset the diamond rotation a bit
//            if (probability > 0.5){
//                rotationOffset = (Math.random()*30)-15;
//            }
//        }
//
//        if(chaosFactor > 0.5){
//            // flip the coin!
//            double probability = Math.random();
//
//            // for a heads, change the size of the diamond a little bit
//            if (probability > 0.5){
//                double shrinkRate = (1 - probability)*0.7;
//                sq.resetSide((int) ((1-shrinkRate)*origSquareSide));
//            }
//        }
//
//        if (chaosFactor > 0.75){
//            // flip a coin!
//            double probability = Math.random();
//
//            if (chaosFactor > 0.9){
//                if (probability > 0.5){
//                    offsetDirection = Math.random()*360;
//                    offsetDistance = (Math.random()*(sq.diagonal()*0.5))*chaosFactor;
//                }
//            } else {
//
//                // for a heads, paint the diamond off center
//                if (probability > 0.5) {
//                    offsetDirection = Math.random() * 360;
//                    offsetDistance = (Math.random() * (sq.diagonal() * 0.5)) * 0.4;
//                }
//            }
//        }
//
//        // move the painter off center from the circle
//        cassatt.tr(offsetDirection);
//        cassatt.mfd(offsetDistance);
//        cassatt.tl(offsetDirection);
//
//        // rotate so that the square becomes a diamond
        cassatt.tr(45);

        cassatt.setColor(randomColor());
//        // paint
        cassatt.paint(sq);

//         rotate back!
        cassatt.tl(45);
//
//        // move the painter back to the center of the circle
//        cassatt.tr(offsetDirection);
//        cassatt.mbk(offsetDistance);
//        cassatt.tl(offsetDirection);
//
//        // if the square's side was adjusted, put it back
//        sq.resetSide((int) origSquareSide);
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }

    // REQUIRED INFRASTRUCTURE

    public HirstLattice(){
        paintTheImage();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run () {
                new HirstLattice();
            }
        });
    }
}
