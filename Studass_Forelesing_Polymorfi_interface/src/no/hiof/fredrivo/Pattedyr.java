package no.hiof.fredrivo;

public abstract class Pattedyr implements HvaDyrKan{
    private String type;
    private String antallBen;

    public Pattedyr(String navn, String antallBen) {
        this.type = navn;
        this.antallBen = antallBen;
    }

    public String getType() {
        return type;
    }

    public String getAntallBen() {
        return antallBen;
    }
}
