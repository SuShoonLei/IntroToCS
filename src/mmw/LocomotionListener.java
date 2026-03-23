package mmw;

import composer.SComposer;

public class LocomotionListener
{
    public static void main(String[] args) {
        SComposer s = new SComposer();
        s.text();
        System.out.println("HillFlat ..."); s.mms_85_HillFlat(); space(s);
        System.out.println("HillStones ..."); s.mms_86_HillStones(); space(s);
        System.out.println("Hill"); s.mms_87_Hill(); space(s);
        System.out.println("Hills"); s.mms_88_Hills(); space(s);
        System.out.println("PrepJump"); s.mms_86_PrepJump();
        System.out.println("Stagger"); s.mms_87_Stagger();
        System.out.println("StraggerUpDown"); s.mms_87_StaggerUpDown();
        System.out.println("StrollDown"); s.mms_85_StrollDown();
        System.out.println("Stroll"); s.mms_87_Stroll();
        System.out.println("StrollUpDown"); s.mms_87_StrollUpDown();
        System.out.println("ZagZig"); s.mms_87_ZagZig();
        System.out.println("ZigZag"); s.mms_87_ZigZag();
        s.untext();
    }

    private static void space(SComposer s) {
        s.untext(); s.rest(); s.text();
    }
}
