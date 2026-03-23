package horde;

import painter . SPainter ;
import javax . swing . SwingUtilities ;


public class MonsterTester {
    public MonsterTester () {
         Monster mc = new Monster("Su", 54,4,7);
         MonsterHorde mh = new MonsterHorde(2);
         mh.paint(new SPainter(1000,1000));
       // System.out.println(mh.toString());
    }

    public static void main ( String [] args ) {
        SwingUtilities . invokeLater ( new Runnable () {
            public void run () {
                new MonsterTester () ;
            }
        }) ;
    }
}
