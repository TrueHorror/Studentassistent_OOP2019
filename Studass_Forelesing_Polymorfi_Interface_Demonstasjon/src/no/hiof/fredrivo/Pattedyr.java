package no.hiof.fredrivo;

public abstract class Pattedyr implements HvaDyrKan {
    private String navn;
    private String antallBen;

    public Pattedyr(String navn, String antallBen) {
        this.navn = navn;
        this.antallBen = antallBen;
    }

    public String getNavn() {
        return navn;
    }

    public String getAntallBen() {
        return antallBen;
    }
}
