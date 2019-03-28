package no.hiof.fredrivo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Lager 3 Pattedyr objekter som er en hund, ku og katt.
        Pattedyr enHund = new Hund("Lassie", "4");
        Pattedyr enKu = new Ku("Molly", "4");
        Pattedyr enKatt = new Katt("Pus", "4");


        //Oppretter ArrayList som skal innehodle alle dyrene på en bondegård.
        ArrayList<Pattedyr> bondegård = new ArrayList<>();


        //Plaserer dyrene på bondegården
        bondegård.add(enHund);
        bondegård.add(enKatt);
        bondegård.add(enKu);


        //Hva gjør hvert av dyrene på bondegården?
        for (Pattedyr p: bondegård) {
            hvaGjørDyr(p);
        }

    }

    //Metode som kaller på hva dyret gjør daglig og hva som er spesiellt med dyret.
    public static void hvaGjørDyr(Pattedyr dyr){

        System.out.println(dyr.lagLyd());
        System.out.println(dyr.spise());
        System.out.println(dyr.bevegeSeg());

        if (dyr instanceof Hund){
            Hund hund = (Hund)dyr;
            System.out.println(hund.ledeBlinde());

        }
        else if (dyr instanceof Katt){
            Katt katt = (Katt)dyr;
            System.out.println(katt.kutteOppFjesetDitt());

        }
        else {
            Ku ku = (Ku)dyr;
            System.out.println(ku.giMelk());

        }
    }

}
