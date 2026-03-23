package npw;

import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SSquare;

public class SquareSymmetry {
    //THE SOLUTION TO SquareSymmetry PROBLEM
    private void paintTheImage() {
        SPainter ps = new SPainter(" SquareSymmetry ",800,800);
        SSquare sq = new SSquare(150);
        ps.setColor(Color.YELLOW);
        ps.paint(sq);

        ps.mfd(250);
        ps.mrt(250);
        sq.s3();
        ps.setColor(Color.BLUE);
        ps.paint(sq);

        ps.mlt(500);
        ps.paint(sq);


        ps.mbk(500);
        ps.paint(sq);

        ps.mrt(500);
        ps.paint(sq);

        sq.x3();
        ps.mfd(170);
        sq.s2();
        ps.setColor(Color.PINK);
        ps.draw(sq);

        ps.mlt(500);
        ps.draw(sq);

        ps.mfd(100);
        ps.draw(sq);

        ps.mrt(500);
        ps.draw(sq);


    }
    //REQUIRED INFRASTRUCTURE

    public SquareSymmetry() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {new SquareSymmetry();
            }
        });
    }
}
