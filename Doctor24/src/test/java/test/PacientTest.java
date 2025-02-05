package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obiecte.Pacient;
import obiecte.Particularitati;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testare functionalitati clasa Pacient
 */
class PacientTest {

    private Pacient pacient;
    private Particularitati particularitati;

    /**
     * Creare instanta a clasei inainte de fiecare test
     */
    @BeforeEach
    void setUp() {
        particularitati = new Particularitati("Masculin", 30, 70, 170);
        pacient = new Pacient("john_doe", "password123", "John Doe", particularitati);
    }

    /**
     * Test getter nume
     */
    @Test
    void testGetNume() {
        assertEquals("John Doe", pacient.getNume());
    }

    /**
     * Test getter username
     */
    @Test
    void testGetUsername() {
        assertEquals("john_doe", pacient.getUsername());
    }

    /**
     * Test getter parola
     */
    @Test
    void testGetPassword() {
        assertEquals("password123", pacient.getPassword());
    }

    /**
     * Test getter sex
     */
    @Test
    void testGetSex() {
        assertEquals("Masculin", pacient.getSex());
    }

    /**
     * Test getter varsta
     */
    @Test
    void testGetVarsta() {
        assertEquals(30, pacient.getVarsta());
    }

    /**
     * Test getter greutate
     */
    @Test
    void testGetGreutate() {
        assertEquals(70, pacient.getGreutate());
    }
    
    /**
     * Test getter inaltime
     */
    @Test
    void testGetInaltime() {
        assertEquals(170, pacient.getInaltime());
    }
    
    /**
     * Test setter istoric
     */
    @Test
    void testGetIstoric() {
        assertEquals("{}", pacient.getIstoric());
    }

    /** 
     * Test setter nume
     */
    @Test
    void testSetNume() {
        pacient.setNume("Jane Doe");
        assertEquals("Jane Doe", pacient.getNume());
    }

    /** 
     * Test setter sex
     */
    @Test
    void testSetSex() {
        pacient.setSex("Feminin");
        assertEquals("Feminin", pacient.getSex());
    }

    /**
     * Test setter varsta
     */
    @Test
    void testSetVarsta() {
        pacient.setVarsta(35);
        assertEquals(35, pacient.getVarsta());
    }

    /**
     * Test setter greutate
     */
    @Test
    void testSetGreutate() {
        pacient.setGreutate(75);
        assertEquals(75, pacient.getGreutate());
    }
    

    /**
     * Test setter inaltime
     */
    @Test
    void testSetInaltimne() {
        pacient.setInaltime(180);
        assertEquals(180, pacient.getInaltime());
    }
}

