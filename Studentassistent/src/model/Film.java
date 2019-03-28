package hiof.no.Oblig4.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film> {


    //-----------------------------//
    //       Constructors         //
    //---------------------------//

    public Film(String Tittel, String Beskrivelse, double spilletid, LocalDate utgivelsesDato) {

        super(Tittel, Beskrivelse,spilletid,utgivelsesDato);

    }


    public Film(String Tittel, String Beskrivelse, double spilletid, LocalDate utgivelsesDato, Person regissor) {

        super(Tittel, Beskrivelse, spilletid, utgivelsesDato, regissor);

    }



    @Override
    public String toString() {
        return
                getTittel()
                        + " " +
                        getSpilleTid()
                        + " " +
                        getUtgivelsesDato();


    }

    @Override
    public int compareTo(Film filmen) {

        return this.getTittel().toLowerCase().compareTo(filmen.getTittel().toLowerCase());

    }
}

