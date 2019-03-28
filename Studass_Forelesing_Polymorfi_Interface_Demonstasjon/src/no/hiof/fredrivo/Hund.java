package no.hiof.fredrivo;

public class Hund extends Pattedyr {

    public Hund(String navn, String antallBen) {
        super(navn, antallBen);
    }

    @Override
    public String lagLyd() {
        return "Woof!";
    }

    @Override
    public String spise() {
        return "Hunden spiser matrestene på gulvet.";
    }

    @Override
    public String bevegeSeg() {
        return "Hunden løper fort.";
    }

    public String ledeBlinde(){
        return "Hunder kan lede blinde";
    }

}
