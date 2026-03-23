package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

public class GeomatricArt {
    //THE SOLUTION TO THE Geometric Art PROBLEM
    private void paintTheImage() {
        SPainter cassatt = new SPainter("Geomatric Art",400,400);

        SCircle dot = new SCircle(120);
        SSquare sq = new SSquare(150);

        paintCornerSquare(cassatt, dot, sq);
        paintRedCircles(cassatt,dot);
        paintWhiteDiamond(cassatt,sq);
    }
    //REQUIRED INFRASTRUCTURE

    public GeomatricArt() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GeomatricArt();
            }
        });
    }

    public static void paintCornerSquare(SPainter sp, SCircle dot, SSquare sq){
        sp.mfd(100);
        sp.mrt(100);
        sp.setColor(Color.BLUE);
        sq.s2();
        sp.paint(sq);

        sp.mbk(200);
        sp.paint(sq);

        sp.mlt(200);
        sp.paint(sq);

        sp.mfd(200);
        sp.paint(sq);

        sq.x2();
        sp.mrt(100);
        sp.mbk(100);
    }
    public static void paintRedCircles(SPainter sp,SCircle cr){
        sp.setColor(Color.RED);
        sp.paint(cr);
    }
    public static void paintWhiteDiamond(SPainter sp, SSquare cr){
        sp.setHeading(45);
        sp.setColor(Color.WHITE);
        sp.paint(cr);
    }

}
