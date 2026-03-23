package space;

import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;
import shapes.SSquare;
import shapes.SPolygon;

import java.awt.*;
import java.awt.geom.Point2D;

public class Alien {
    private String name;
    private int size;
    private int nrOfLegs;
    private int nrOfEyes;
    private Color color;

    public Alien(String name, int size, int nrOfLegs, int nrOfEyes, Color color) {
        this.name = name;
        this.size = size/5;
        this.nrOfLegs = nrOfLegs;
        this.nrOfEyes = nrOfEyes;
        this.color = randomColor();

    }

    public String toString(){
        String st = "Name of the Alien is " + name + " and it is "+size+ " big, having " + nrOfLegs+" legs and "+nrOfEyes+ " eyes.";
        return st;
    }

    public void paint(SPainter sp) {
        SCircle eye = new SCircle(size / 3);
        SRectangle leg = new SRectangle(2,(size-eye.radius()));
        int random;

        double rotation = 360.0 / (nrOfEyes);
        for (int i = 0; i < nrOfEyes; i++) {
            sp.mrt(leg.width()/2);
            sp.paint(leg);
            sp.mlt(leg.width()/2);
            random = (int) (Math.random()*2);
            sp.mrt(size);
            sp.draw(eye);
            eye.s2();
            sp.setColor(randomColor());
            sp.paint(eye);
            eye.s2();
            sp.setColor(Color.BLACK);
            if(random == 0){
                sp.mlt(eye.radius()/2);
                sp.paint(eye);
                sp.mrt(eye.radius()/2);
            }else {
                sp.mrt(eye.radius()/2);
                sp.paint(eye);
                sp.mlt(eye.radius()/2);
            }
            eye.x2();
            eye.x2();
            sp.mlt(size);
            sp.tr(rotation);

        }
    }

        private static Color randomColor() {
            int rv = (int) (Math.random() * 256);
            int gv = (int) (Math.random() * 256);
            int bv = (int) (Math.random() * 256);
            return new Color(rv, gv, bv);
        }
    }
