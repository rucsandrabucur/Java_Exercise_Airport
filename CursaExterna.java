public class CursaExterna extends Cursa {

    private String taraProvenienta;

    public CursaExterna(double pret, int numarPasageri, String destinatie, boolean areEscala, String taraProvenienta) {
        super(pret * 0.9, numarPasageri, destinatie, areEscala);
        this.taraProvenienta = taraProvenienta;
    }
}
