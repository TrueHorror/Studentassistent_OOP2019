package no.hiof.fredrivo;

public class Katt extends Pattedyr {

    public Katt(String navn, String antallBen) {
        super(navn, antallBen);
    }

    @Override
    public String lagLyd() {
        return "Mjau!";
    }

    @Override
    public String spise() {
        return "Katten spiser fisk.";
    }

    @Override
    public String bevegeSeg() {
        return "Katten løper fortere.";
    }

    public String kutteOppFjesetDitt(){
        return "Katter kan kutte opp fjeset ditt.";
    }

}
