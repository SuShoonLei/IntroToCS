package npw;

import painter.SPainter;
import shapes.SRectangle;
import shapes.SSquare;

import java.awt.*;

public class Invention1 {
    public static void main(String[] args) {
        SPainter sp = new SPainter(990,990);
        sp.paintFrame(Color.WHITE,100);
        SRectangle re = new SRectangle(20,40);
        SSquare sq = new SSquare(40);

        sp.mfd(460);
        sp.mlt(495);

        for(int i =0; i < 10; i++){
            paintOneFullCol(sp,sq,re);
            sp.mrt(55);
        }

    }
    private static void paintOneFullCol(SPainter sp, SSquare sq, SRectangle cr){
        int row = 0;
        while(row<9){
            paintCr(sp,cr,0);
            sp.mbk(55);
            paintsq(sp,sq);
            sp.mbk(55);
            row+=1;
        }
        sp.mfd(55);
        sp.mrt(55);
        while (row>0){
            paintCr(sp,cr,1);
            sp.mfd(110);
            row-=1;
        }
        sp.mbk(55);
    }
    private static void paintCr(SPainter sp, SRectangle cr, int i){

        if(i==0){sp.setColor(Color.YELLOW);}
        else {sp.setColor(Color.GREEN);}

//        cr.setRadius(10);
        sp.paint(cr);
    }
    private static void paintsq(SPainter sp, SSquare sq){
        sp.setHeading(45);
        sp.setColor(Color.cyan);
        sp.paint(sq);

        sp.setColor(Color.PINK);
        sq.s3();
        sp.paint(sq);
        sq.x3();
        sp.setHeading(0);
    }

}
