package models;

public class Autor extends Persoana {
    private String nationalitate;
    private int anNastere;
    private int nrCartiScrise;

    public Autor(String nume, String email, String telefon, String nationalitate, int anNastere, int nrCartiScrise) {
        super(nume, email, telefon);
        this.nationalitate = nationalitate;
        this.anNastere = anNastere;
        this.nrCartiScrise = nrCartiScrise;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public int getAnNastere() {
        return anNastere;
    }

    public int getNrCartiScrise() {
        return nrCartiScrise;
    }

    @Override
    public String toString() {
        return "Autor -> " + super.toString() + ", Nationalitate: " + nationalitate + ", Născut: " + anNastere + ", Cărți scrise: " + nrCartiScrise;
    }
}
