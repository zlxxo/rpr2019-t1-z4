package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void dodajPedesetiArtikl() {
        Korpa korpa = new Korpa();
        for(int i = 1; i < 50; i++) {
            korpa.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        int brojArtikala = korpa.getBrojArtikala();
        korpa.dodajArtikl(new Artikl("Boja", 20, "1234"));
        assertEquals(brojArtikala + 1, korpa.getBrojArtikala());
        Artikl[] artikli = korpa.getArtikli();
        assertNotNull(artikli[49]);
        assertEquals("Boja", artikli[49].getNaziv());
        assertEquals(20, artikli[49].getCijena());
        assertEquals("1234", artikli[49].getKod());
    }

    @Test
    void dodajPedesetprviArtikl() {
        Korpa korpa = new Korpa();
        for(int i = 1; i <= 50; i++) {
            korpa.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        assertEquals(50, korpa.getBrojArtikala());
        korpa.dodajArtikl(new Artikl("Sapun", 3, "1654"));
        assertEquals(50, korpa.getBrojArtikala());
    }

    @Test
    void izbaciArtikal() {
        Korpa korpa = new Korpa();
        for(int i = 1; i <= 5; i++) {
            korpa.dodajArtikl(new Artikl("Žvake", 1, Integer.toString(i)));
        }
        assertEquals(5, korpa.getBrojArtikala());
        korpa.izbaciArtiklSaKodom("1");
        assertEquals(4, korpa.getBrojArtikala());

        boolean postoji = false;
        Artikl[] artikli = korpa.getArtikli();
        for(int i = 0; i < 50; i++) {
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
        Korpa korpa = new Korpa();
        for(int i = 1; i <= 5; i++) {
            korpa.dodajArtikl(new Artikl("Žvake", 1, "1"));
        }
        assertEquals(5, korpa.getBrojArtikala());
        korpa.izbaciArtiklSaKodom("1");
        assertEquals(0, korpa.getBrojArtikala());

        boolean postoji = false;
        Artikl[] artikli = korpa.getArtikli();
        for(int i = 0; i < 50; i++) {
            Artikl artikl = artikli[i];
            if(artikl != null) {
                postoji =  true;
                break;
            }
        }

        assertFalse(postoji);
    }

}