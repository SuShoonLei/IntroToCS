/*
 *Program to paint a blue dot in the context of the Nonrepresentational
 *Painting World, NPW.
 */

package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;
import shapes.SSquare;

public class BlueDot {
    //THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter cassatt = new SPainter("Geometric Art",400,400);
        SCircle dot = new SCircle(120);
        SSquare sq = new SSquare(150);

        paintCornerSquares(cassatt, dot, sq);
        paintRedCircle(cassatt,dot);
        paintWhiteDiamond(cassatt,sq);
    }

    private void paintWhiteDiamond(SPainter cassatt, SSquare sq) {

    }

    private void paintRedCircle(SPainter cassatt, SCircle dot) {

    }

    private void paintCornerSquares(SPainter cassatt, SCircle dot, SSquare sq) {

    }
    //REQUIRED INFRASTRUCTURE

    public BlueDot() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlueDot();
            }
        });
    }
}