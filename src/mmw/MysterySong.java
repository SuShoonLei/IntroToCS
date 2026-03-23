package mmw;

import note.SNote;

public class MysterySong {
    public static void main(String[] args) {
        SNote n = new SNote();
        n.text();
        n.rp(2); n.play(); n.play();
        n.lp(2);n.play(); n.play();
        n.rp(2); n.play(); n.play();
        n.rp(2); n.x2(); n.play(); n.s2();
        n.lp(3); n.play();
        n.rp(1); n.s2(); n.play();
        n.rp(1); n.play(); n.x2();
        n.lp(1); n.play();
        n.lp(1); n.play();
        n.lp(1); n.x2(); n.play(); n.play();

        System.out.println();
    }
}


