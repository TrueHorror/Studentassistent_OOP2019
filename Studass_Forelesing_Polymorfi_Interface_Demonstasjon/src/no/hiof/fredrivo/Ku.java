package no.hiof.fredrivo;

public class Ku extends Pattedyr {

    public Ku(String navn, String antallBen) {
        super(navn, antallBen);
    }

    @Override
    public String lagLyd() {
        return "Muu!";
    }

    @Override
    public String spise() {
        return "Kuen spiser gress.";
    }

    @Override
    public String bevegeSeg() {
        return "Kuen løper kanskje ikke så veldig fort.";
    }

    public String giMelk(){
        return "Vi kan få melk av kuen.";
    }
}
