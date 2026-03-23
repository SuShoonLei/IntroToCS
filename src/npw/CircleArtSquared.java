package npw ;

import painter.SPainter ;
import shapes.SCircle;
import shapes.SSquare ;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner ;

public class CircleArtSquared {

    private void paintTheImage() {

        // determine the canvas dimensions
        int canvasHeight = getNumber(" Canvas height ");
        int canvasWidth = getNumber(" Canvas width ");
        // determine how many squares should appear
        int numberOfRows = getNumber("How many rows ");
        int numberOfColumns = getNumber("How many columns ");
        int numberOfNestedSqs = getNumber(" Number of nested circles ");

        // instantiate the painter and canvas
        SPainter cassatt = new SPainter(" Circle Squared Art", canvasWidth, canvasHeight);
        // frame the canvas : we want a 10 unit frame of white on all sides .
        int frameDepth = 10;

        // use the canvasHeight , frameDepth , and number of rows to see how tall each square can be
        double potentialSquareHeight = (double) (canvasHeight - 20) / (double)
                numberOfRows;

        // similarly , see how wide each square can be
        double potentialSquareWidth = (double) (canvasWidth - 20) / (double)
                numberOfColumns;

        // the square has an integer side length that is the minimum of the two possible values
        int sideLength = (int) Math.min(potentialSquareHeight, potentialSquareWidth);

        // make the basic square tile
        SSquare sq = new SSquare(sideLength);

// move cassatt up the required number of squares to paint the top row
        if(numberOfRows %2==0) {
            cassatt.mfd((numberOfRows / 2 - 0.5) * sq.side());
        } else {
            cassatt.mfd((numberOfRows / 2) * sq.side());
        }
// move cassatt left the required number of squares , to paint the
        // square in the top left corner
        if(numberOfColumns%2==0) {
            cassatt.mlt((numberOfColumns / 2 - 0.5) * sq.side());
        } else

        {
            cassatt.mlt((numberOfColumns / 2) * sq.side());
        }

        // now start painting each square tile !
        int rowNumber = 0;
        int colNumber = 0;
        while(rowNumber<numberOfRows ) {
            // paint a square tile for each column
            while (colNumber < numberOfColumns) {
                paintSquareTile(cassatt, sq, numberOfNestedSqs);
                cassatt.mrt(sq.side());
                colNumber = colNumber + 1;
            }
            // move left , to the start of the row
            cassatt.mlt(colNumber * sq.side());
            // move down , to prepare to paint a new row
            cassatt.mbk(sq.side());
            colNumber = 0;
            rowNumber = rowNumber + 1;
        }

    }

    private void paintSquareTile ( SPainter cassatt , SSquare sq , int n ) {
        paintMainSquareTile ( cassatt , sq ) ;

        // There are two types : concentric nested square tiles
        // and right / left veering nested square tiles .
        // First , choose which type to do.
        int chanceForType = (int) (Math.random()*2);
        if (chanceForType ==0) {
//paint concentric squares
            paintConcentricSubSquares(cassatt, sq, n);
        } else {
            //paint right or left veering squares
            //
            // but now, choose whatever to go left or right
            int chanceForDirection = (int) (Math.random()*2);
            if (chanceForDirection == 0) {
                paintLeftSideSubSquares ( cassatt , sq , n ) ;
            } else {
                paintRightSideSubSquares ( cassatt , sq , n ) ;
            }
        }
    }
    private void paintConcentricSubSquares ( SPainter cassatt , SSquare sq , int n ) {
        int numPaintedSqs = 1;
        SSquare smallerSq = sq ;
        while ( numPaintedSqs < n ) {
            cassatt . setColor ( randomColor () ) ;
            double s = (( n - 1) * smallerSq . side () ) / n ;
            smallerSq = new SSquare ( s ) ;
            SCircle cr = smallerSq.inscribingCircle();
            cassatt . paint ( cr ) ;
            numPaintedSqs = numPaintedSqs + 1;
        }
    }

    private void paintLeftSideSubSquares ( SPainter cassatt , SSquare sq , int n ) {
        int numPaintedSqs = 1;
        double offsetToLeft = 0;
        SSquare smallerSq = sq ;
        while ( numPaintedSqs < n ) {
            cassatt . setColor ( randomColor () ) ;
            double s = (( n - 1) * smallerSq . side () ) / n ;
            smallerSq = new SSquare ( s ) ;
            cassatt . mlt ( s /(4* n ) ) ;
            offsetToLeft = offsetToLeft + s /(4* n ) ;
            SCircle cr = smallerSq.inscribingCircle();
            cassatt . paint ( cr ) ;
            numPaintedSqs = numPaintedSqs + 1;
        }
        cassatt . mrt ( offsetToLeft ) ;
    }

    private void paintMainSquareTile ( SPainter cassatt , SSquare sq ) {
        cassatt . setColor ( randomColor () ) ;
        cassatt . paint ( sq ) ;
        cassatt . setColor ( Color . BLACK ) ;
        cassatt . draw ( sq ) ;
    }
    private void paintRightSideSubSquares ( SPainter cassatt , SSquare sq , int n ) {
        cassatt . tr (180) ;
        paintLeftSideSubSquares ( cassatt , sq , n ) ;
        cassatt . tl (180) ;
    }

    public Color randomColor () {
        int rv = (int ) ( Math . random () *256) ;
        int gv = (int ) ( Math . random () *256) ;
        int bv = (int ) ( Math . random () *256) ;
        return new Color ( rv , gv , bv ) ;
    }

    private static int getNumber ( String prompt ) {
        String nss = JOptionPane . showInputDialog (null , prompt + "?") ;
        Scanner scanner = new Scanner ( nss ) ;
        return scanner . nextInt () ;
    }

    // Required Infrastructure
    public CircleArtSquared () {
        paintTheImage () ;
    }

    public static void main ( String [] args ) {
        SwingUtilities . invokeLater ( new Runnable () {
            public void run () {
                new CircleArtSquared() ;
            }
        }) ;
    }
}
