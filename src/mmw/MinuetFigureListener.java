package mmw;

import composer.SComposer;

public class MinuetFigureListener {
    public static void main(String[] args) {
        SComposer c = new SComposer();
        c.text();
        System.out.println("c.mms1 ..."); c.mms_31_JSB_M1(); space(c);
        System.out.println("c.mms2 ..."); c.mms_33_JSB_M2(); space(c);
        System.out.println("c.mms3 ..."); c.mms_33_JSB_M3(); space(c);
        System.out.println("c.mms4 ..."); c.mms_33_JSB_M4(); space(c);
        System.out.println("c.mms5 ..."); c.mms_33_JSB_M5(); space(c);
        System.out.println("c.mms6 ..."); c.mms_34_JSB_M6(); space(c);
        System.out.println("c.mms7 ..."); c.mms_34_JSB_M7(); space(c);
        System.out.println("c.mms8 ..."); c.mms_34_JSB_M8(); space(c);
        System.out.println("c.mms9 ..."); c.mms_35_JSB_M9(); space(c);
        System.out.println("c.mms10 ..."); c.mms_35_JSB_M10(); space(c);
        System.out.println("c.mms11 ..."); c.mms_35_JSB_M11(); space(c);
        System.out.println("c.mms12 ..."); c.mms_35_JSB_M12(); space(c);
        System.out.println("c.mms13 ..."); c.mms_35_JSB_M13(); space(c);
        System.out.println("c.mms14 ..."); c.mms_36_JSB_M14(); space(c);
        System.out.println("c.mms15 ..."); c.mms_36_JSB_M15(); space(c);
        c.untext(); 
    }

    private static void space(SComposer c) {
        c.untext(); c.rest(2); c.text();
    }
}