package npw;

import java.awt.Color;
import java.util.Random;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;
public class Balloons {

    public Balloons() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Balloons();
            }
        }); }
    private void paintTheImage() {
        SPainter painter = new SPainter("Balloons", 600, 600);
        paintSky(painter);
        int nrOfBalloons = 100;
        paintBalloons(painter,nrOfBalloons);
    }
    private void paintSky(SPainter ter) {
        ter.setColor(Color.pink);
        SSquare sky = new SSquare(2000);
        ter.paint(sky);
    }
    private void paintBalloons(SPainter painter, int nrOfBalloons) {
        int i = 1;
        while ( i <= nrOfBalloons ) {
            paintOneBalloon(painter);
            i = i + 1;
        }
    }
    private void paintOneBalloon(SPainter painter) {
        Random rgen = new Random();
        int rn = rgen.nextInt(3);
        if ( rn == 0 ) { painter.setColor(Color.RED);
        } else if ( rn == 1 ) {
            painter.setColor(Color.CYAN);
        } else {
            painter.setColor(Color.YELLOW);
        }
        painter.move();
        int balloonRadius = 20;
        SCircle balloon = new SCircle(balloonRadius);
        painter.paint(balloon);
        painter.setColor(Color.BLACK);
        painter.draw(balloon);
    }
}