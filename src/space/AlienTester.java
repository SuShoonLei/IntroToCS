package space;
import space.Alien;
import space.AlienTester;
import painter.SPainter;
import javax.swing.SwingUtilities;
import java.awt.*;

public class AlienTester {

    public AlienTester() {
        Alien alien = new Alien("Su", 54,4,7, Color.CYAN);

        SpaceInvasion SI = new SpaceInvasion(2, Color.CYAN);
        SI.paint(new SPainter(1000,1000));
//         System.out.println(mh.toString());
//        alien.paint(new SPainter(1000,1000));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AlienTester();
            }
        });
    }
}
