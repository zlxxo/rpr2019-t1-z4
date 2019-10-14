package ba.unsa.etf.rpr;

public class Supermarket {
    private final int maksimalanBrojArtikala = 1000;
    private Artikl[] artikli = new Artikl[1000];
    private int brojArtikala = 0;

    public void dodajArtikl(Artikl artikl) {
        if(brojArtikala < maksimalanBrojArtikala) {
            artikli[brojArtikala++] = artikl;
        }
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
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
                break;
            }
        }
        return artikl;
    }
}
