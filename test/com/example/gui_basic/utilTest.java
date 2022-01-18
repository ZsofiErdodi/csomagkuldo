package com.example.gui_basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class utilTest {

    util util = null;

    @BeforeEach
    void setUp() {
        util = new util();
    }

    @AfterEach
    void tearDown() {
 //       util.clear();
    }

    @Test
    @DisplayName("Részeredmény és végeredmény számítását végző függvény tesztje")
    void szamitasTeszt() {
    //1. 0 <  t < 5 km, S méret (11,5x36x61 cm), 0 < m <= 1 kg, különböző darabszámok
        util.ssz = 1;
        util.szum = 0;
        util.szamitas(1, 61, 36, 1, 0.1);
        assertEquals(500, util.reszeredm);
        assertEquals(500, util.szum);
        assertEquals(2, util.ssz);


        util.ssz = 2;
        util.szum = 0;
        util.szamitas(2, 61, 36, 3.2, 0.2);
        assertEquals(500, util.reszeredm);
        assertEquals(425, util.szum);
        assertEquals(3, util.ssz);

        util.ssz = 4;
        util.szum = 0;
        util.szamitas(3, 61, 36, 8, 0.6);
        assertEquals(500, util.reszeredm);
        assertEquals(425, util.szum);
        assertEquals(5, util.ssz);

        util.ssz = 5;
        util.szum = 0;
        util.szamitas(4, 61, 36, 10, 0.99);
        assertEquals(500, util.reszeredm);
        assertEquals(375, util.szum);
        assertEquals(6, util.ssz);

        util.ssz = 6;
        util.szum = 0;
        util.szamitas(4, 61, 36, 11.5, 1);
        assertEquals(500, util.reszeredm);
        assertEquals(375, util.szum);
        assertEquals(7, util.ssz);

    //2. 5 <= t < 100 km, M méret (19,5x36x61 cm), 1 < m <= 3 kg, különböző darabszámok
        util.ssz = 1;
        util.szum = 0;
        util.szamitas(5, 61, 36, 11.6, 1.1);
        assertEquals(907.5, util.reszeredm);
        assertEquals(907.5, util.szum);
        assertEquals(2, util.ssz);

        util.ssz = 2;
        util.szum = 0;
        util.szamitas(12, 61, 36, 12, 2);
        assertEquals(907.5, util.reszeredm);
        assertEquals(771.375, util.szum);
        assertEquals(3, util.ssz);

        util.ssz = 4;
        util.szum = 0;
        util.szamitas(54, 61, 36, 15.4, 2.32);
        assertEquals(907.5, util.reszeredm);
        assertEquals(771.375, util.szum);
        assertEquals(5, util.ssz);

        util.ssz = 5;
        util.szum = 0;
        util.szamitas(78, 61, 36, 19, 2.9);
        assertEquals(907.5, util.reszeredm);
        assertEquals(680.625, util.szum);
        assertEquals(6, util.ssz);

        util.ssz = 6;
        util.szum = 0;
        util.szamitas(99, 36, 61, 19.5, 3);
        assertEquals(907.5, util.reszeredm);
        assertEquals(680.625, util.szum);
        assertEquals(7, util.ssz);

    //3. t >= 100 km, L méret (37,5x36x61 cm), 3 < m <= 10 kg, különböző darabszámok
        util.ssz = 1;
        util.szum = 0;
        util.szamitas(100, 36, 61, 19.6, 3.1);
        assertEquals(1440, util.reszeredm);
        assertEquals(1440, util.szum);
        assertEquals(2, util.ssz);

        util.ssz = 2;
        util.szum = 0;
        util.szamitas(101, 20, 36, 61, 5);
        assertEquals(1440, util.reszeredm);
        assertEquals(1224, util.szum);
        assertEquals(3, util.ssz);

        util.ssz = 4;
        util.szum = 0;
        util.szamitas(154, 32, 36, 61, 6.32);
        assertEquals(1440, util.reszeredm);
        assertEquals(1224, util.szum);
        assertEquals(5, util.ssz);

        util.ssz = 5;
        util.szum = 0;
        util.szamitas(478, 37, 36, 61, 9.9);
        assertEquals(1440, util.reszeredm);
        assertEquals(1080, util.szum);
        assertEquals(6, util.ssz);

        util.ssz = 6;
        util.szum = 0;
        util.szamitas(985, 37.5, 36, 61, 10);
        assertEquals(1440, util.reszeredm);
        assertEquals(1080, util.szum);
        assertEquals(7, util.ssz);

    //4. t >= 100 km, L méret (37,5x36x61 cm), 10 < m <= 20 kg, különböző darabszámok
        util.ssz = 1;
        util.szum = 0;
        util.szamitas(100, 19.6, 36, 61, 10.1);
        assertEquals(1560, util.reszeredm);
        assertEquals(1560, util.szum);
        assertEquals(2, util.ssz);

        util.ssz = 2;
        util.szum = 0;
        util.szamitas(214, 25, 36, 61, 14);
        assertEquals(1560, util.reszeredm);
        assertEquals(1326, util.szum);
        assertEquals(3, util.ssz);

        util.ssz = 4;
        util.szum = 0;
        util.szamitas(327, 34.6, 36, 61, 17.13);
        assertEquals(1560, util.reszeredm);
        assertEquals(1326, util.szum);
        assertEquals(5, util.ssz);

        util.ssz = 5;
        util.szum = 0;
        util.szamitas(543, 36.12, 36, 61, 19.9);
        assertEquals(1560, util.reszeredm);
        assertEquals(1170, util.szum);
        assertEquals(6, util.ssz);

        util.ssz = 6;
        util.szum = 0;
        util.szamitas(612, 37.5, 36, 61, 20);
        assertEquals(1560, util.reszeredm);
        assertEquals(1170, util.szum);
        assertEquals(7, util.ssz);

    }

    @Test
    void reset() {
    }

    @Test
    void clear() {
    }

    @Test
    void inputCheck() {
    }
}