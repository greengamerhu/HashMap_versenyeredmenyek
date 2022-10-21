package hu.petrik.versenyeredmenyek;

public class Eredmeny {
    private String reszIdo, nev;


    public Eredmeny(String reszIdo, String nev) {
        this.reszIdo = reszIdo;
        this.nev = nev;
    }

    public String getReszIdo() {
        return reszIdo;
    }

    public String getNev() {
        return nev;
    }

    public int getReszIdoPerc() {
        return Integer.parseInt(reszIdo.split(":")[0]);
    }
    public int getReszIdoMasodperc() {
        return Integer.parseInt(reszIdo.split(":")[1]);

    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nev, this.reszIdo);
    }
}
