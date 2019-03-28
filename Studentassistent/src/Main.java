package hiof.no.Oblig4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import hiof.no.Oblig4.model.*;



public class Main {

    public static void main(String[] args) {


        //-----------------------------//
        //Sesonger/Episoder oppgave4  //
        //---------------------------//


        System.out.println("**************************\n");


        TVSerie GameOfThrones = new TVSerie("Game Of Thrones", "Best TV Show Evah!", "17/04/2011", 5);

        Random randomTallGenerator = new Random();

        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {
                GameOfThrones.leggTilEpisode(new Episode(episodeNr, sesongNr, "Episode: " + episodeNr, "generic Description", randomTallGenerator.nextInt(11) + 20));

            }
        }


        //-----------------------------//
        //      Regissør Objekter     //
        //---------------------------//


        Person GeorgeRRM = new Person("George", "Raymond Richard Martin", 70, 'M');
        Person jhonnyKnoxville = new Person("Jhonny", "Knoxville", 45, 'M');
        Person kitHarrington = new Person("Kit", "Harrington", 34, 'M');
        Person bamMargera = new Person("Bam", "Margera", 34, 'M');
        //-----------------------------//
        //        RolleObjekter       //
        //---------------------------//

        Rolle rolle1 = new Rolle("Jhonny", "knoxville", jhonnyKnoxville);

        Rolle rolle2 = new Rolle("test1", "Snow", kitHarrington);
        Rolle rolle3 = new Rolle("test2", "Snow", kitHarrington);
        Rolle rolle4 = new Rolle("test3", "Snow", kitHarrington);
        Rolle rolle5 = new Rolle("John", "Snow", kitHarrington);
        Rolle rolle6 = new Rolle("Bam", "Margera", bamMargera);


        //-----------------------------//
        //        FilmObjekter        //
        //---------------------------//


        Film BadGrandpa = new Film("Bad grandpa", "The worst way to raise a child in america by his grandfather", 1.45, LocalDate.of(2013, 10, 24), jhonnyKnoxville);
        Film fireAndFlames = new Film("A tale of Fire and ice", "Game of thrones movie", 3.10, LocalDate.of(2019, 10, 24), GeorgeRRM);


        //--------------------------------------//
        // Legger til Roller i TVSerier/film    //
        //--------------------------------------//

        BadGrandpa.leggTilRolle(rolle1);
        BadGrandpa.leggTilRolle(rolle6);

        fireAndFlames.leggTilRolle(rolle2);
        fireAndFlames.leggTilRolle(rolle3);
        fireAndFlames.leggTilRolle(rolle4);
        fireAndFlames.leggTilRolle(rolle5);






        //--------------------------------------//
        //     Henter ut  episoder + print      //
        //--------------------------------------//

        ArrayList<Episode> episodeListe = GameOfThrones.getEpisodeListe();

        System.out.println("**************************");
        System.out.println("* " + GameOfThrones + " *");
        System.out.println("**************************");
        System.out.println("-------Alle Episoder------");


        for (Episode enEpisode : episodeListe) {
            System.out.println(enEpisode);
        }


        //--------------------------------------//
        //     Henter ut  Roller   + print      //
        //--------------------------------------//


        System.out.println(BadGrandpa.hentRolleBesetning());
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println(fireAndFlames.hentRolleBesetning());
        //Henter ut alle roller som er i en enkel episode.
        System.out.println("--------------------------------------------------------------------------------------------------");


        //Henter ut alle roller i selve tvserien
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println(GameOfThrones.hentRollebesetning());

    }

}