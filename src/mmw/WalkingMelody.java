package mmw;

import composer.SComposer;

public class WalkingMelody {
    public static void main(String[] args) {
        SComposer s = new SComposer();
        s.text();
        s.mms_88_Hills();
        s.mms_87_Stagger();
        s.mms_87_Stroll();
        s.mms_87_ZagZig();
        s.mms_87_ZigZag();
        s.mms_88_Hills();
        s.untext();
    }
}

