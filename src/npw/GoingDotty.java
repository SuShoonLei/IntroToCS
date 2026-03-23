/*
 *Program to paint a blue dot in the context of the Nonrepresentational
 *Painting World, NPW.
 */

package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;

public class GoingDotty {
    //THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter cassatt = new SPainter("Going Dotty",600,600);
        SCircle dot = new SCircle(75);
        paintYellowDot(cassatt, dot);
        paintRedDot(cassatt, dot);
        paintBlueDot(cassatt, dot);
        paintGrayDot(cassatt, dot);

    }

    private void paintGrayDot(SPainter cassatt, SCircle dot) {
        cassatt.setColor(Color.gray);

        cassatt.mfd(200); //up
        cassatt.paint(dot);

        cassatt.mbk(400); //down
        cassatt.paint(dot);
        cassatt.mfd(200); //center

        cassatt.mlt(200); //left
        cassatt.paint(dot);

        cassatt.mrt(400); //right
        cassatt.paint(dot);
        cassatt.mlt(200); //center

    }

    private void paintBlueDot(SPainter cassatt, SCircle dot) {
        cassatt.setColor(Color.blue);

        dot.s2();

        cassatt.mfd(200);   //move to top right
        cassatt.mrt(200);
        cassatt.paint(dot);

        cassatt.mbk(400);  //move to bottom left
        cassatt.mlt(400);
        cassatt.paint(dot);

        cassatt.mfd(200); //back to center
        cassatt.mrt(200);

        dot.x2();
    }

    private void paintRedDot(SPainter cassatt, SCircle dot) {
        cassatt.setColor(Color.red);

        dot.s2();
        cassatt.mlt(200);  //move to top left
        cassatt.mfd(200);
        cassatt.paint(dot);

        cassatt.mbk(400);   //move to bottom right
        cassatt.mrt(400);
        cassatt.paint(dot);

        cassatt.mfd(200); //back to center
        cassatt.mlt(200);
        dot.x2();

    }

    private void paintYellowDot(SPainter cassatt, SCircle dot) {

        cassatt.setColor(Color.yellow);

        dot.s2();
        cassatt.paint(dot);
        dot.x2();

    }

    // REQUIRED INFRASTRUCTURE
    public GoingDotty() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GoingDotty();
            } });
    }
}