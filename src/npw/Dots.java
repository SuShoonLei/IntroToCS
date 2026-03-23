package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

public class Dots {
    //THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter ps = new SPainter(" SquareSymmetry ",800,800);
        SCircle dot = new SCircle(100);
        ps.draw(dot);
        ps.mfd(250);
        ps.mrt(250);
        ps.setColor(Color.BLUE);
        dot.setRadius(70);
        ps.draw(dot);
        ps.mlt(500);
        ps.draw(dot);
        ps.mbk(250);
        ps.setColor(Color.RED);
        dot.setRadius(40);
        ps.draw(dot);
        ps.mrt(500);
        ps.draw(dot);
        ps.mbk(250);
        ps.setColor(Color.GREEN);
        ps.paint(dot);
        dot.setRadius(120);
        ps.draw(dot);
        ps.mlt(500);
        ps.draw(dot);
        dot.setRadius(40);
        ps.paint(dot);


    }
    //REQUIRED INFRASTRUCTURE

    public Dots() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Dots();
            }
        });
    }
}

