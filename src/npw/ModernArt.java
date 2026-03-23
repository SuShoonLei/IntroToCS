package npw;

import shapes.SCircle;
import java.awt.Color;
import painter.SPainter;

public class ModernArt {
    public static void main(String[] args) {
        SPainter sp = new SPainter("Modern Art", 800,800);
        SCircle dot = new SCircle(50);  //size 1

        sp.draw(dot); // (color 1 default black) (1 unfilled)

        sp.setColor(Color.red); // color 2

        sp.mfd(150 );       //draw 4 red dots (total 5 unfilled)
        sp.draw(dot);           //top 2 red circles
        sp.mfd(150);
        sp.draw(dot);

        sp.mbk(600);        //bottom 2
        sp.mlt(150);
        sp.draw(dot);
        sp.mrt(300);
        sp.draw(dot);
        sp.mlt(150);

        sp.mfd(120);


        dot.x2(); //size 2 size up by 2
        sp.setColor(Color.cyan); //color 3
        sp.paint(dot);             //draw 3 cyan circle(filled)
        sp.mlt(300);
        sp.paint(dot);
        sp.mrt(600);
        sp.paint(dot);
        sp.mlt(300);
        sp.mfd(180);

        dot.s3(); //size 3 shrink by 3
        sp.setColor(Color.blue); //color 4

        sp.mlt(300);        //draw 4 blue circles(filled)
        sp.paint(dot);
        sp.mfd(200);
        sp.paint(dot);
        sp.mrt(600);
        sp.paint(dot);
        sp.mbk(200);
        sp.paint(dot);

        sp.mlt(300); //back to center

    }
}
