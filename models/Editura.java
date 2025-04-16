package models;

import java.util.List;
import java.util.ArrayList;

public class Editura {
    private String nume;
    private String adresa;
    private int anInfiintare;

    public Editura(String nume, String adresa, int anInfiintare) {
        this.nume = nume;
        this.adresa = adresa;
        this.anInfiintare = anInfiintare;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getAnInfiintare() {
        return anInfiintare;
    }

    private List<Carte> cartiPublicate = new ArrayList<>();

    public void adaugaCartePublicata(Carte carte) {
        cartiPublicate.add(carte);
    }

    @Override
    public String toString() {
        return "Editura: " + nume + ", Adresa: " + adresa + ", Fondată în: " + anInfiintare;
    }
}