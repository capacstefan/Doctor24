package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obiecte.Particularitati;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testare functionalitati clasa Particularitati
 */
class ParticularitatiTest {

    private Particularitati particularitati;

    /**
     * Creare instanta a clasei inainte de fiecare test
     */
    @BeforeEach
    void setUp() {

        particularitati = new Particularitati("M", 30, 70, 170);
    }

    /**
     * Test getter sex
     */
    @Test
    void testGetSex() {

        assertEquals("M", particularitati.getSex());
    }

    /**
     * Test setter sex
     */
    @Test
    void testSetSex() {
 
        particularitati.setSex("F");
        assertEquals("F", particularitati.getSex());
    }

    /**
     * Test getter varsta
     */
    @Test
    void testGetVarsta() {

        assertEquals(30, particularitati.getVarsta());
    }

    /**
     * Test setter varsta
     */
    @Test
    void testSetVarsta() {

        particularitati.setVarsta(35);
        assertEquals(35, particularitati.getVarsta());
    }

    /**
     * Test getter greutate
     */
    @Test
    void testGetGreutate() {

        assertEquals(70, particularitati.getGreutate());
    }

    /**
     * Test setter greutate
     */
    @Test
    void testSetGreutate() {

        particularitati.setGreutate(75);
        assertEquals(75, particularitati.getGreutate());
    }
    
    /**
     * Test getter inaltime
     */
    @Test
    void testGetInaltime() {

        assertEquals(170, particularitati.getInaltime());
    }

    /**
     * Test setter inaltime
     */
    @Test
    void testSetInaltime() {

        particularitati.setInaltime(170);
        assertEquals(170, particularitati.getInaltime());
    }
}

