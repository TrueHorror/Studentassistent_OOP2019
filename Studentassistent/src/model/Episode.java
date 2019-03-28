package hiof.no.Oblig4.model;

public class Episode extends Produksjon implements Comparable<Episode> {

    private int episodeNummer;
    private int sesong;


    //-----------------------------//
    //        Constructors        //
    //---------------------------//


    public Episode(int episodeNummer, int sesong, String Tittel, String Beskrivelse, double spilletid) {
        super(Tittel, Beskrivelse, spilletid);
        this.episodeNummer = episodeNummer;
        this.sesong = sesong;


    }


    //-----------------------------//
    //        Getters             //
    //---------------------------//

    public int getEpisodeNumber() {
        return episodeNummer;

    }

    public int getSesong() {
        return sesong;

    }


    //-----------------------------//
    //        Setters             //
    //---------------------------//

    public void setEpisodeNumber(int newEpisodeNumber) {
        episodeNummer = newEpisodeNumber;

    }

    public void setSesong(int newSesong) {
        sesong = newSesong;

    }


    //-----------------------------//
    //        toString() Method   //
    //---------------------------//

    @Override
    public String toString() {
        return "\n" + getTittel() + " " + episodeNummer + " Sesong: " + sesong + " Spilletid: " + getSpilleTid() + getRolleListe();
    }

    @Override
    public int compareTo(Episode episodene) {

        if (this.getSesong() == episodene.getSesong() ) {

            return episodene.getEpisodeNumber() - episodene.getEpisodeNumber();
        }
        else {
            return this.getSesong() - episodene.getSesong();

        }

    }
}