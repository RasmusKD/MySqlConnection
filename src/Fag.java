import java.util.ArrayList;

public class Fag {
    private int fagnr;
    private String fagNavn;
    private ArrayList<Studerende> klasseListe = new ArrayList<>();

    public Fag() {
    }

    public Fag(int fagnr, String fagNavn) {
        this.fagnr = fagnr;
        this.fagNavn = fagNavn;
    }

    public Fag(int fagnr, String fagNavn, ArrayList<Studerende> klasseListe) {
        this.fagnr = fagnr;
        this.fagNavn = fagNavn;
        this.klasseListe = klasseListe;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public String getFagNavn() {
        return fagNavn;
    }

    public void setFagNavn(String fagNavn) {
        this.fagNavn = fagNavn;
    }

    public ArrayList<Studerende> getKlasseListe() {
        return klasseListe;
    }

    public void setKlasseListe(ArrayList<Studerende> klasseListe) {
        this.klasseListe = klasseListe;
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagnr=" + fagnr +
                ", fagNavn='" + fagNavn + '\'' +
                ", klasseListe=" + klasseListe +
                '}';
    }
}