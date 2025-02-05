package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obiecte.Diagnostic;
import obiecte.ParteCorp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * Testare functionalitati clasa ParteCorp
 */
class ParteCorpTest {

    private ParteCorp parteCorp;
    private Diagnostic diagnostic;

    /**
     * Creare instanta a clasei inainte de fiecare test
     */
    @BeforeEach
    void setUp() {
        diagnostic = new Diagnostic("Durere de cap", new ArrayList<>(), "Stres", "Odihna", false);
        ArrayList<Diagnostic> diagnostice = new ArrayList<>();
        diagnostice.add(diagnostic);
        parteCorp = new ParteCorp("Cap", diagnostice);
    }
    
    /**
     * Test getter nume
     */
    @Test
    void testGetNume() {
        assertEquals("Cap", parteCorp.getNume());
    }

    /**
     * Test getter diagnostice
     */
    @Test
    void testGetDiagnostice() {
        assertNotNull(parteCorp.getDiagnostice());
        assertFalse(parteCorp.getDiagnostice().isEmpty());
        assertEquals(1, parteCorp.getDiagnostice().size());
    }
    /**
     * Test getter diagnostice gol
     */
    @Test
    void testGetDiagnosticeEmpty() {
        ParteCorp parteCorpEmpty = new ParteCorp("Brat", new ArrayList<>());
        assertTrue(parteCorpEmpty.getDiagnostice().isEmpty());
    }
}

