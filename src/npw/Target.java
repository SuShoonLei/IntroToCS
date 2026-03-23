/*
 *Program to paint a blue dot in the context of the Nonrepresentational
 *Painting World, NPW.
 */

package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;

public class Target {
    //THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter klee = new SPainter("Target",600,600);
        SCircle outer = new SCircle(150);
        klee.setColor(Color.RED);
        klee.paint(outer);
        SCircle inner = new SCircle(100);
        klee.setColor(Color.WHITE);
        klee.paint(inner);
        SCircle center = new SCircle(50);
        klee.setColor(Color.RED);
        klee.paint(center);
    }
    //REQUIRED INFRASTRUCTURE
    public Target() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Target();
            }
        });
    }
}