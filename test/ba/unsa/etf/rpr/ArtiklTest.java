package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtiklTest {

    @Test
    void getNaziv() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        assertEquals("Šampon", artikl.getNaziv());
    }

    @Test
    void getCijena() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        assertEquals(12, artikl.getCijena());
    }

    @Test
    void getKod() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        assertEquals("1234", artikl.getKod());
    }

    @Test
    void setNaziv() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        artikl.setNaziv("Wash&Go");
        assertEquals("Wash&Go", artikl.getNaziv());
    }

    @Test
    void setCijena() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        artikl.setCijena(10);
        assertEquals(10, artikl.getCijena());
    }

    @Test
    void setKod() {
        Artikl artikl = new Artikl("Šampon", 12, "1234");
        artikl.setKod("1245");
        assertEquals("1245", artikl.getKod());
    }
}