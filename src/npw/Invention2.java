package npw;

import painter.SPainter;
import shapes.SCircle;

import java.awt.*;

public class Invention2 {
    public static void main(String[] args) {
        SPainter sp = new SPainter(800,650);
        SCircle cr = new SCircle(50);

        sp.mfd(300);
        sp.mlt(400);

        for(int i = 0 ; i<9; i++){
            paintOneFullCol(sp,cr,i);
            sp.mrt(100);
        }

    }
    private static void paintOneFullCol(SPainter sp, SCircle cr, int i){
        int move = 0;
        if(i%2 ==0){
            while(move <= 650){
                paintOneRT(sp,cr);
                sp.mbk(100);
                sp.setHeading(90);
                paintOneRT(sp,cr);
                sp.setHeading(0);
                sp.mbk(100);
                move += 200;
            }
            sp.mfd(move);
        }
        else {
            while(move <= 650){
                sp.setHeading(90);
                paintOneRT(sp,cr);
                sp.setHeading(0);
                sp.mbk(100);
                paintOneRT(sp,cr);
                sp.mbk(100);
                move += 200;
            }
            sp.mfd(move);
        }
    }
    private static void paintOneRT(SPainter sp, SCircle cr){

        int turn = (int) (Math.random() * 4);
        if(turn==0){
            sp.setColor(randomColor());
            sp.paint(cr);
        }
        if(turn==1){
            sp.setColor(randomColor());
            cr.shrink(25);
            sp.paint(cr);}
        if(turn==2){
            sp.setColor(randomColor());
            cr.shrink(20);
            sp.paint(cr);}
        if(turn==3){
            sp.setColor(randomColor());
            cr.shrink(15);
            sp.paint(cr);}
        cr.setRadius(50);

    }
    private static Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color(rv, gv, bv);
    }
}
