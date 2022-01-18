package com.example.gui_basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class util {

    private static void print(String output) {
        System.out.println(output);
    }


    static double reszeredm = 0;
    static double szum = 0;
    static Integer ssz = 1;       // csomag sorszáma, hat az árra is

    public static Double[] meretSorban(Double x, Double y, Double z) {
        Double[] meretek = new Double[]{x, y, z};
        Arrays.sort(meretek);
        return meretek;
    }

    public static double szamitas(int tav, double m1, double m2, double m3, double tomeg) {
        Double[] meretek = meretSorban(m1, m2, m3);
        m3 = meretek[2];

        // meg kell keverni a számokat, mert m1 (az egyetlen változó érték a csomagméreteknél) lehet nagyobb, mint m2 (m1 max 37.5, m2 max 36)
        if (meretek[0] <= 36 ) {
            m2 = meretek[0];
            m1 = meretek[1];
        } else {
            m1 = meretek[0];
            m2 = meretek[1];
        }

        if (tav < 5) {
            reszeredm = 500;
        } else if (tav < 100) {
            reszeredm = 750;
        } else if (tav >= 100) {
            reszeredm = 1000;
        }

        if ((m1 > 11.5) && (m1 <= 19.5)) {
            reszeredm = 1.1 * reszeredm;
        } else if (m1 > 19.5) {
            reszeredm = 1.2 * reszeredm;
        }

        if ((tomeg > 1) && (tomeg <= 3)) {
            reszeredm = 1.1 * reszeredm;
        } else if ((tomeg > 3) && (tomeg <= 10)) {
            reszeredm = 1.2 * reszeredm;
        } else if ((tomeg > 10) && (tomeg <= 20)) {
            reszeredm = 1.3 * reszeredm;
        }

        BigDecimal bd1 = new BigDecimal(reszeredm).setScale(2, RoundingMode.HALF_UP);
        reszeredm = bd1.doubleValue();
        BigDecimal bd2 = new BigDecimal(szum).setScale(2, RoundingMode.HALF_UP);
        szum = bd2.doubleValue();

        szum = szum + reszeredm;

        if (ssz >= 2 && ssz < 5) {
            szum = szum * 0.85;
        } else if (ssz >= 5) {
            szum = szum * 0.75;
        }

        ssz++;
        System.out.println("Részeredmény: " + reszeredm + " Szum: " + szum + " Köv sorszám: " + ssz);      // ez nem kell

        return szum;
    }

    public static void reset() {
        main.m1Mezo.setText("");
        main.m2Mezo.setText("");
        main.m3Mezo.setText("");
        main.tavMezo.setText("");
        main.tomegMezo.setText("");

        main.m1Mezo.setStyle("-fx-background-color: WHITE");
        main.m2Mezo.setStyle("-fx-background-color: WHITE");
        main.m3Mezo.setStyle("-fx-background-color: WHITE");
        main.tomegMezo.setStyle("-fx-background-color: WHITE");
        main.tavMezo.setStyle("-fx-background-color: WHITE");
    }

    public static void clear() {
        reset();
        reszeredm = 0;
        szum = 0;
        ssz = 1;
        main.sszMezo.setText(ssz.toString());
        main.osszeg.setText(Double.toString(szum));
    }

    public static boolean inputCheck() {
        boolean jovagynem = true;
        System.out.println(" inputCheck ");

        //színek visszaállítása
        main.m1Mezo.setStyle("-fx-background-color: WHITE");
        main.m2Mezo.setStyle("-fx-background-color: WHITE");
        main.m3Mezo.setStyle("-fx-background-color: WHITE");
        main.tomegMezo.setStyle("-fx-background-color: WHITE");
        main.tavMezo.setStyle("-fx-background-color: WHITE");

        try {
            Double.parseDouble(main.m1Mezo.getText());
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m1Mezo.setStyle("-fx-background-color: RED");
            if (main.m1Mezo.getText() == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Double.parseDouble(main.m2Mezo.getText());
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m2Mezo.setStyle("-fx-background-color: RED");
            if (main.m2Mezo.getText() == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Double.parseDouble(main.m3Mezo.getText());
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m3Mezo.setStyle("-fx-background-color: RED");
            if (main.m3Mezo.getText() == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        // FONTOS, hogy ez az if itt legyen, mert eddig még csak a méret mezőket néztük, tehát most biztos, hogy a méret mezők megfelelő formátumú adatokkal vannak töltve
        if (jovagynem) {
            Double[] m = meretSorban(Double.parseDouble(main.m1Mezo.getText()), Double.parseDouble(main.m2Mezo.getText()), Double.parseDouble(main.m3Mezo.getText()));
            Double a = m[0];
            Double b = m[1];
            Double c = m[2];
            if ( (c > 61.0) || (b > 37.5) || (a > 36) ) {
                jovagynem = false;
                main.m1Mezo.setStyle("-fx-background-color: RED");
                main.m2Mezo.setStyle("-fx-background-color: RED");
                main.m3Mezo.setStyle("-fx-background-color: RED");
                errormessage.display("A feladott csomag tömege nem lehet nagyobb 37,5 cm x 36 cm x 61 cm-nél");
            }
        }

        try {
            Double.parseDouble(main.tomegMezo.getText());
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            if (main.tomegMezo.getText() == "") {
                errormessage.display("Üres tömeg mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }
        if (Double.parseDouble(main.tomegMezo.getText()) > 20) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            errormessage.display("A feladott csomag tömege nem lehet több 20 kg-nál");
        }

        try {
            Integer.parseInt(main.tavMezo.getText());
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.tavMezo.setStyle("-fx-background-color: RED");
            if (main.tavMezo.getText() == "") {
                errormessage.display("Üres szállítási távolság mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        return jovagynem;
    }


}
