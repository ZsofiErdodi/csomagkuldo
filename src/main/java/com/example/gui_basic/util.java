package com.example.gui_basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class util {

    private static void print(String output) {
        System.out.println(output);
    }


    static double reszeredm = 0;
    static double szum = 0;
    static Integer ssz = 1;       // csomag sorszáma, hat az árra is


    public static double szamitas(int tav, double m1, double tomeg) {
        // double m2;              //m2 és m3 csak akkor kell, ha megnézzük, hogy túl nagyot írtak-e be, vagy ha sorbarendezősen nézzük a számokat
        // double m3;              // a legnagyobb lehet max 61, ha a 2. legnagyobb max 36, akkor a legkisebb érték lesz m1; de ha 36 és 37,5 közti, akkor ez lesz m1

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
        if (main.m1Mezo.getText() == "") {
            jovagynem = false;
            main.m1Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Üres méret mező");
        }
        if (main.m2Mezo.getText() == "") {
            jovagynem = false;
            main.m2Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Üres méret mező");
        }
        if (main.m3Mezo.getText() == "") {
            jovagynem = false;
            main.m3Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Üres méret mező");
        }
        if (main.tomegMezo.getText() == "") {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            errormessage.display("Üres tömeg mező");
        } else if (Double.parseDouble(main.tomegMezo.getText()) > 20) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            errormessage.display("A feladott csomag tömege nem lehet több 20 kg-nál");
        }

        if (main.tavMezo.getText() == "") {
            jovagynem = false;
            main.tavMezo.setStyle("-fx-background-color: RED");
            errormessage.display("Üres szállítási távolság mező");
        }

        //színek visszaállítása
        if (jovagynem) {
            main.m1Mezo.setStyle("-fx-background-color: WHITE");
            main.m2Mezo.setStyle("-fx-background-color: WHITE");
            main.m3Mezo.setStyle("-fx-background-color: WHITE");
            main.tomegMezo.setStyle("-fx-background-color: WHITE");
            main.tavMezo.setStyle("-fx-background-color: WHITE");
        }
        return jovagynem;
    }


}
