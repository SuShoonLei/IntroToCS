package horde;


import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;

import java.awt.*;

public class Monster {

    private String name;
    private  int size;
    private int numberOfLegs;
    private int numberOfEyes;
    private Color color;

    public Monster(String name, int size, int numberOfLegs, int numberOfEyes){
        this.name = name;
        this.size = size;
        this.numberOfLegs = numberOfLegs;
        this.numberOfEyes = numberOfEyes;
        this.color = randomColor();
    }

    public String toString(){
        String st = "Name of monster is " + name + " and it is "+size+ " big, having "+numberOfLegs+" legs and "+numberOfEyes+ " eyes.";
        return st;
    }

    public void paint(SPainter sp){
        SCircle body = new SCircle(size);
        SCircle eye = new SCircle(size/10);
        SRectangle leg = new SRectangle(4,size);

        double rotation = 180.0/(numberOfLegs+1);
        sp.tr(rotation);
        for (int i = 0; i<numberOfLegs; i++) {

            sp.mrt(size);
            sp.paint(leg);
            sp.mlt(size);
            sp.tr(rotation);
        }

        sp.setHeading(0);



        sp.setColor(color);
        sp.paint(body);
        sp.setColor(Color.BLACK);

        rotation = 180.0/(numberOfEyes-1);
        for(int i = 0; i<numberOfEyes; i++ ) {
            sp.mlt(size);
            sp.paint(eye);
            eye.x2();
            sp.draw(eye);
            eye.s2();
            sp.mrt(size);
            sp.tr(rotation);
        }
        sp.setHeading(0);
    }


    private static Color randomColor() {
        int rv = (int)(Math.random()*256);
        int gv = (int)(Math.random()*256);
        int bv = (int)(Math.random()*256);
        return new Color(rv,gv,bv);
    }
}