package hiof.no.Oblig4.model;

import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Produksjon {

    private String Tittel;
    private double spilletid;
    private LocalDate utgivelsesDato;
    private String Beskrivelse;
    private Person regissor;
    private ArrayList<Rolle> RolleListe;



    //-----------------------------//
    //       Getters              //
    //---------------------------//

    public String getTittel() {
        return Tittel;

    }

    public double getSpilleTid() {
        return spilletid;

    }

    public LocalDate getUtgivelsesDato() {
        return utgivelsesDato;
    }


    public String getBeskrivelse() {
        return Beskrivelse;
    }

    public Person getRegissor() {
        return regissor;
    }
    public ArrayList<Rolle> getRolleListe() {
        return RolleListe;
    }


    //-----------------------------//
    //       Setters              //
    //---------------------------//

    public void setEpisodeTittel(String newepisodeTittel) {
        Tittel = newepisodeTittel;

    }

    public void setSpilleTid(double newSpilleTid) {
        spilletid = newSpilleTid;

    }


    public void setUtgivelsesDato(LocalDate utgivelsesDato) {
        this.utgivelsesDato = utgivelsesDato;
    }


    public void setBeskrivelse(String Beskrivelse) {
        this.Beskrivelse = Beskrivelse;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }
    public void setRolleListe(ArrayList<Rolle> rolleListe) {
        RolleListe = rolleListe;
    }

    //-----------------------------//
    //       Constructors         //
    //---------------------------//


    public Produksjon(String Tittel, String Beskrivelse, double spilletid){

        this.Tittel = Tittel;
        this.Beskrivelse = Beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesDato = utgivelsesDato;
    }

    public Produksjon(String Tittel, String Beskrivelse, double spilletid, LocalDate utgivelsesDato){

        this.Tittel = Tittel;
        this.Beskrivelse = Beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesDato = utgivelsesDato;
    }


    public Produksjon(String Tittel,String Beskrivelse, double spilletid, LocalDate utgivelsesDato, Person regissor) {
        this.Tittel = Tittel;
        this.spilletid = spilletid;
        this.utgivelsesDato = utgivelsesDato;
        this.Beskrivelse = Beskrivelse;
        this.regissor = regissor;
        RolleListe = new ArrayList<Rolle>();

    }



    public Produksjon(ArrayList<Rolle> rolleListe) {
        RolleListe = rolleListe;
    }



    //-----------------------------//
    //        Methods             //
    //---------------------------//

    public void leggTilRolle(Rolle enRolle){
        RolleListe.add(enRolle);

    }
    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){

            RolleListe.addAll(flereRoller);




    }

    public java.util.ArrayList hentRolleBesetning(){
        ArrayList<Rolle> rollerIEpisoder = getRolleListe();
        ArrayList<ArrayList<Rolle>> episoderISerie = new ArrayList<>();
        for(Rolle rollelagtTil : rollerIEpisoder ){
            episoderISerie.add(rollerIEpisoder);

        }
        return episoderISerie;
    }




}
