/*
 *Program to paint a blue dot in the context of the Nonrepresentational
 *Painting World, NPW.
 */

package npw;

    import java.awt.Color;
    import javax.swing.SwingUtilities;
    import painter.SPainter;
    import shapes.SRectangle;

public class PinkRectangles {
    //THE SOLUTION TO THE PINK RECTANGLE PROBLEM
    private void paintTheImage() {
        SPainter su = new SPainter("Pink Rectangles",800,800);
        SRectangle rec = new SRectangle(100, 200);
        su.setColor(Color.PINK);
        su.paint(rec);
        rec.shrink(50,100);
        su.mbk(200);
        su.paint(rec);
        su.mlt(200);
        su.paint(rec);
        su.mrt(400);
        su.paint(rec);
        su.moveToCenter();;
        su.mfd(200);
        su.paint(rec);
    }
    //REQUIRED INFRASTRUCTURE

    public PinkRectangles() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PinkRectangles();
            }
        });
    }
}
