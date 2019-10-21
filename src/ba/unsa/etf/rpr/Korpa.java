package ba.unsa.etf.rpr;

public class Korpa {
    private final int maksimalanBrojArtikala = 50;
    private Artikl[] artikli = new Artikl[maksimalanBrojArtikala];
    private int brojArtikala = 0;

    public boolean dodajArtikl(Artikl artikl) {
        if(brojArtikala < maksimalanBrojArtikala) {
            artikli[brojArtikala++] = artikl;
            return true;
        }
        return false;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }

    public int getBrojArtikala() {
        return brojArtikala;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        Artikl artikl = null;
        for(int i = 0; i < brojArtikala; i++) {
            artikl = artikli[i];
            if(artikl.getKod().equals(kod)) {
                for(int j = i; j < brojArtikala - 1; j++) {
                    artikli[j] = artikli[j + 1];
                }

                brojArtikala--;
                artikli[brojArtikala] = null;
                i--;
                break;
            }
        }
        return artikl;
    }

    public int dajUkupnuCijenuArtikala() {
        int suma = 0;

        for(int i = 0; i < brojArtikala; i++) {
            suma += artikli[i].getCijena();
        }

        return suma;
    }
}
