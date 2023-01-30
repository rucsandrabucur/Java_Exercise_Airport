public class Cursa {

    private double pret;
    private int numarPasageri;
    private String destinatie;
    private boolean areEscala;

    public Cursa(double pret, int numarPasageri, String destinatie, boolean areEscala) {
        this.pret = pret;
        this.numarPasageri = numarPasageri;
        this.destinatie = destinatie;
        this.areEscala = areEscala;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "pret=" + pret +
                ", numarPasageri=" + numarPasageri +
                ", destinatie='" + destinatie + '\'' +
                ", areEscala=" + areEscala +
                '}';
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getNumarPasageri() {
        return numarPasageri;
    }

    public void setNumarPasageri(int numarPasageri) {
        this.numarPasageri = numarPasageri;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public boolean isAreEscala() {
        return areEscala;
    }

    public void setAreEscala(boolean areEscala) {
        this.areEscala = areEscala;
    }
}

