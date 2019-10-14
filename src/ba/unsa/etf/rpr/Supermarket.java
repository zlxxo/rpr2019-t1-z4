package ba.unsa.etf.rpr;

public class Supermarket {
    private final int maksimalanBrojArtikala = 1000;
    private Artikl[] artikli = new Artikl[1000];

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }
}
