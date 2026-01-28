package no.hvl.data102.filmarkiv.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

    private Filmarkiv filmarkiv;
    private Film f1, f2, f3;

    @BeforeEach
    public void setUp() {
        filmarkiv = new Filmarkiv(10);
        f1 = new Film(1, "Wachowski", "The Matrix", 1999, Sjanger.ACTION, "Warner Bros");
        f2 = new Film(2, "Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
        f3 = new Film(3, "Nolan", "The Dark Knight", 2008, Sjanger.ACTION, "Warner Bros");
    }

    @Test
    public void testLeggTilFilm() {
        assertEquals(0, filmarkiv.antall());
        
        assertTrue(filmarkiv.leggTilFilm(f1));
        assertEquals(1, filmarkiv.antall());
        
        assertTrue(filmarkiv.leggTilFilm(f2));
        assertEquals(2, filmarkiv.antall());
        
        // Test at samme film ikke kan legges til to ganger
        assertFalse(filmarkiv.leggTilFilm(f1));
        assertEquals(2, filmarkiv.antall());
        
        // Test at null ikke kan legges til
        assertFalse(filmarkiv.leggTilFilm(null));
    }

    @Test
    public void testSlettFilm() {
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        assertEquals(3, filmarkiv.antall());
        
        // Slett en film som finnes
        assertTrue(filmarkiv.slettFilm(2));
        assertEquals(2, filmarkiv.antall());
        assertNull(filmarkiv.finnFilm(2));
        
        // Prøv å slette en film som ikke finnes
        assertFalse(filmarkiv.slettFilm(99));
        assertEquals(2, filmarkiv.antall());
    }

    @Test
    public void testFinnFilm() {
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        
        Film funnet = filmarkiv.finnFilm(2);

        assertNotNull(funnet);
        assertEquals(f1, filmarkiv.finnFilm(1));
        assertSame(f2, funnet);
        assertNull(filmarkiv.finnFilm(99));
    }

    @Test
    public void testSoekTittel() {
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        
        // Søk etter "The" - skal finne f1 og f3
        Film[] resultat = filmarkiv.soekTittel("The");
        assertEquals(2, resultat.length);
        
        // Søk etter "Inception" - skal finne f2
        resultat = filmarkiv.soekTittel("Inception");
        assertEquals(1, resultat.length);
        assertSame(f2, resultat[0]);
        
        // Søk etter noe som ikke finnes
        resultat = filmarkiv.soekTittel("Avatar");
        assertEquals(0, resultat.length);
    }

    @Test
    public void testSoekProdusent() {
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        
        // Søk etter "Nolan" - skal finne f2 og f3
        Film[] resultat = filmarkiv.soekProdusent("Nolan");
        assertEquals(2, resultat.length);
        
        // Søk etter "Wachowski" - skal finne f1
        resultat = filmarkiv.soekProdusent("Wachowski");
        assertEquals(1, resultat.length);
        assertSame(f1, resultat[0]);
    }

    @Test
    public void testAntallISjanger() {
        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        
        // f1 og f3 er ACTION, f2 er SCIFI
        assertEquals(2, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antall(Sjanger.SCIFI));
        assertEquals(0, filmarkiv.antall(Sjanger.KOMEDIE));
    }

    @Test
    public void testAntallFilmer() {
        assertEquals(0, filmarkiv.antall());
        
        filmarkiv.leggTilFilm(f1);
        assertEquals(1, filmarkiv.antall());
        
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        assertEquals(3, filmarkiv.antall());
        
        filmarkiv.slettFilm(1);
        assertEquals(2, filmarkiv.antall());
    }
}
