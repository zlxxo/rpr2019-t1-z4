package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void dodajHiljaditiArtikl() {
        Supermarket supermarket = new Supermarket();
        for(int i = 1; i < 1000; i++) {
            supermarket.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        int brojArtikala = supermarket.getBrojArtikala();
        supermarket.dodajArtikl(new Artikl("Boja", 20, "1234"));
        assertEquals(brojArtikala + 1, supermarket.getBrojArtikala());
        Artikl[] artikli = supermarket.getArtikli();
        assertNotNull(artikli[999]);
        assertEquals("Boja", artikli[999].getNaziv());
        assertEquals(20, artikli[999].getCijena());
        assertEquals("1234", artikli[999].getKod());
    }

    @Test
    void dodajHiljaduprviArtikl() {
        Supermarket supermarket = new Supermarket();
        for(int i = 1; i <= 1000; i++) {
            supermarket.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        assertEquals(1000, supermarket.getBrojArtikala());
        supermarket.dodajArtikl(new Artikl("Sapun", 3, "1654"));
        assertEquals(1000, supermarket.getBrojArtikala());
    }

    @Test
    void izbaciArtikal() {
        Supermarket supermarket = new Supermarket();
        for(int i = 1; i <= 5; i++) {
            supermarket.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        assertEquals(5, supermarket.getBrojArtikala());
        supermarket.izbaciArtiklSaKodom("1");
        assertEquals(4, supermarket.getBrojArtikala());

        boolean postoji = false;
        Artikl[] artikli = supermarket.getArtikli();
        for(int i = 0; i < 1000; i++) {
            Artikl artikl = artikli[i];
            if(artikl != null && artikl.getKod().equals("1")) {
                postoji = true;
                break;
            }
        }

        assertFalse(postoji);
    }

    @Test
    void izbaciDupliArtikal() {
        Supermarket supermarket = new Supermarket();
        for(int i = 1; i <= 5; i++) {
            supermarket.dodajArtikl(new Artikl("Žvake", 1, "1"));
        }
        assertEquals(5, supermarket.getBrojArtikala());
        supermarket.izbaciArtiklSaKodom("1");
        assertEquals(0, supermarket.getBrojArtikala());

        boolean postoji = false;
        Artikl[] artikli = supermarket.getArtikli();
        for(int i = 0; i < 1000; i++) {
            Artikl artikl = artikli[i];
            if(artikl != null) {
                postoji =  true;
                break;
            }
        }

        assertFalse(postoji);
    }
}