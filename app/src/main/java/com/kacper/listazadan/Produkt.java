package com.kacper.listazadan;

public class Produkt {
    private String nazwa, opis;
    private float cena;
    private boolean dostepny;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public boolean isDostepny() {
        return dostepny;
    }

    public void setDostepny(boolean dostepny) {
        this.dostepny = dostepny;
    }

    public Produkt(String nazwa, String opis, float cena) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.dostepny = true;
    }

    @Override
    public String toString() {
        return "Produkt: " +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena;
    }
}
