package hiof.no.Oblig4.Data;


import hiof.no.Oblig4.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataHandler {


    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();


    public static ObservableList<Film> hentFilmData() {


        if (filmListe.isEmpty()) {


            genererFilmData();
        }

        return filmListe;

    }



    private static void genererFilmData() {

        filmListe.add(new Film("Bad Grandpa", "The worst way to raise a Grandsom", 1.33, LocalDate.of(2013, 10, 24), null));
        filmListe.add(new Film("A tale of Fire and ice", "Game of thrones movie", 3.10, LocalDate.of(2019, 10, 24), null));
        filmListe.add(new Film("John Wick", "They killed his dog, now he is on a rampage", 2.30, LocalDate.of(2019, 10, 24), null));
    }




}
