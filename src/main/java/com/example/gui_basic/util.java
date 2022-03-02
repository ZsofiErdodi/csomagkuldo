package com.example.gui_basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class util {

    static double reszeredm = 0;
    static double reszszum = 0;
    static double szum = 0;
    static Integer ssz = 1;       // csomag sorszáma, hat az árra is
    static Double m1;
    static Double m2;
    static Double m3;

  /**  MÉRETEK SORBARENDEZÉSE
   *     meg kell keverni a számokat, mert m1 (az egyetlen változó érték a csomagméreteknél) lehet nagyobb, mint m2
   *     SORBARENDEZÉS UTÁN: m2 max 36,   m1 a 36 fölötti legkisebb szám,   m3 a legnagyobb szám
   */
    public static void meretSorban(Double x, Double y, Double z) {
        Double[] meretek = new Double[]{x, y, z};
        Arrays.sort(meretek);

        if (meretek[1] > 36 ) {
            m1 = meretek[1];
            m2 = meretek[0];
            m3 = meretek[2];
        } else {
            m1 = meretek[0];
            m2 = meretek[1];
            m3 = meretek[2];
        }
    }

  /**
   *   SZÁMÍTÁS
   */
    public static double szamitas(int tav, double meret1, double meret2, double meret3, double tomeg) {
        meretSorban(meret1, meret2, meret3);

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

        reszszum = reszszum + reszeredm;

        if (ssz < 2) {
            szum = reszszum;
        } else {
            if (ssz >= 2 && ssz < 5) {
                szum = reszszum * 0.85;
            } else if (ssz >= 5) {
                szum = reszszum * 0.75;
            }
        }

        ssz++;

        return szum;
    }

  /**
   *   MEZŐK ÜRESRE ÁLLÍTÁSA
   */
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

  /**
   *   TELJES CSOMAGFELADÁSI FOLYAMAT TÖRLÉSE
   */
    public static void clear() {
        reset();
        reszeredm = 0;
        reszszum = 0;
        szum = 0;
        ssz = 1;
        main.sszMezo.setText(ssz.toString());
        main.osszeg.setText(Double.toString(szum));
    }

  /**
   *   BEVITELI MEZŐK ELLENŐRZÉSE (FORMAI & ÉRTÉK ELLENŐRZÉS)
   */
    public static boolean inputCheck(String tav, String meret1, String meret2, String meret3, String tomeg) {
        boolean jovagynem = true;

        //színek visszaállítása
        main.m1Mezo.setStyle("-fx-background-color: WHITE");
        main.m2Mezo.setStyle("-fx-background-color: WHITE");
        main.m3Mezo.setStyle("-fx-background-color: WHITE");
        main.tomegMezo.setStyle("-fx-background-color: WHITE");
        main.tavMezo.setStyle("-fx-background-color: WHITE");

        try {
            Double.parseDouble(meret1);
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m1Mezo.setStyle("-fx-background-color: RED");
            if (meret1 == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Double.parseDouble(meret2);
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m2Mezo.setStyle("-fx-background-color: RED");
            if (meret2 == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Double.parseDouble(meret3);
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.m3Mezo.setStyle("-fx-background-color: RED");
            if (meret3 == "") {
                errormessage.display("Üres méret mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Double.parseDouble(tomeg);
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            if (tomeg == "") {
                errormessage.display("Üres tömeg mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        try {
            Integer.parseInt(tav);
        } catch(NumberFormatException e) {
            jovagynem = false;
            main.tavMezo.setStyle("-fx-background-color: RED");
            if (tav == "") {
                errormessage.display("Üres szállítási távolság mező");
            } else {
                errormessage.display("A megadott adat formátuma nem megfelelő");
            }
        }

        // Értékek ellenőrzése: max érték a térfogatra és a tömegra, egyik mező sem lehet <= 0
        // FONTOS, hogy ezek az ifek a mezők formátumának ellenőrzése után legyenek
        meretSorban(Double.parseDouble(meret1), Double.parseDouble(meret2), Double.parseDouble(meret3));
        if ( (m1 > 37.5) || (m2 > 36) || (m3 > 61) ) {
            jovagynem = false;
            main.m1Mezo.setStyle("-fx-background-color: RED");
            main.m2Mezo.setStyle("-fx-background-color: RED");
            main.m3Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("A feladott csomag mérete nem lehet nagyobb 37,5 cm x 36 cm x 61 cm-nél");
        }

        if (Double.parseDouble(meret1) <= 0) {
            jovagynem = false;
            main.m1Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Az érték nem lehet kisebb vagy egyenlő 0-nál");
        }
        if (Double.parseDouble(meret2) <= 0) {
            jovagynem = false;
            main.m2Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Az érték nem lehet kisebb vagy egyenlő 0-nál");
        }
        if (Double.parseDouble(meret3) <= 0) {
            jovagynem = false;
            main.m3Mezo.setStyle("-fx-background-color: RED");
            errormessage.display("Az érték nem lehet kisebb vagy egyenlő 0-nál");
        }
        if (Double.parseDouble(tomeg) <= 0) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            errormessage.display("Az érték nem lehet kisebb vagy egyenlő 0-nál");
        } else if (Double.parseDouble(tomeg) > 20) {
            jovagynem = false;
            main.tomegMezo.setStyle("-fx-background-color: RED");
            errormessage.display("A feladott csomag tömege nem lehet több 20 kg-nál");
        }
        if (Integer.parseInt(tav) <= 0) {
            jovagynem = false;
            main.tavMezo.setStyle("-fx-background-color: RED");
            errormessage.display("Az érték nem lehet kisebb vagy egyenlő 0-nál");
        }
        return jovagynem;
    }


}
