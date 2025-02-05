package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obiecte.Diagnostic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * Testare functionalitati clasa Diagnostic
 */
public class DiagnosticTest {

    private Diagnostic diagnostic;

    /**
     * Creare instanta a clasei inainte de fiecare test
     */
    @BeforeEach
    void setUp() {
        diagnostic = new Diagnostic("Febra", new ArrayList<>(), "Infectie virala", "Odihna", true);
    }

    /**
     * Test getter nume
     */
    @Test
    void testGetNume() {
        assertEquals("Febra", diagnostic.getNume());
    }

    /**
     * Test getter cauze
     */
    @Test
    void testGetCauze() {
        assertEquals("Infectie virala", diagnostic.getCauze());
    }

    /**
     * Test getter indicatii
     */
    @Test
    void testGetIndicatii() {
        assertEquals("Odihna", diagnostic.getIndicatii());
    }

    /**
     * Test getter gravitate
     */
    @Test
    void testGetGrav() {
        assertTrue(diagnostic.getGrav());
    }

    /**
     * Test getter simptome
     */
    @Test
    void testGetSimptome() {
        assertNotNull(diagnostic.getSimptome());
        assertTrue(diagnostic.getSimptome().isEmpty());
    }
}
