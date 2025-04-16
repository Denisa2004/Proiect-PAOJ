package models;

import java.util.List;
import java.util.ArrayList;

public class Sectiune {
    private String nume;
    private String locatie;
    private int capacitate;

    public Sectiune(String nume, String locatie, int capacitate) {
        this.nume = nume;
        this.locatie = locatie;
        this.capacitate = capacitate;
    }

    public String getNume() {
        return nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getCapacitate() {
        return capacitate;
    }

    private List<Carte> carti = new ArrayList<>();

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }

    @Override
    public String toString() {
        return "Sectiune: " + nume + ", Locație: " + locatie + ", Capacitate: " + capacitate;
    }
}