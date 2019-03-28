package no.hiof.sclarsen.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import no.hiof.sclarsen.Data.DataHandler;
import no.hiof.sclarsen.MainJavaFx;
import no.hiof.sclarsen.Modell.Film;

import java.io.IOException;

public class FilmController {

    @FXML
    private ListView lstFilm;
    @FXML
    private TextField txtSpilletid;
    @FXML
    private Label Tittel;
    @FXML
    private TextArea txtBeskrivelse;
    @FXML
    private TextField txtUtgivelsesdato;
    private int valgtFilm = 0;
    private ObservableList<Film> filmListe;

    public void initialize() {
        filmListe = DataHandler.hentFilmData();
        if (valgtFilm < filmListe.size()) {
            Film enFilm = filmListe.get(valgtFilm);
            fyllUtFilmInfo(enFilm);
        }
        lstFilm.setItems(DataHandler.hentFilmData());
        lstFilm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film film, Film nyFilm) {
                valgtFilm = lstFilm.getSelectionModel().getSelectedIndex();
                fyllUtFilmInfo(nyFilm);
            }
        });

    }

    private void fyllUtFilmInfo(Film enFilm) {
        if (enFilm != null) {
            Tittel.setText(String.valueOf(enFilm.getTittel()));
            txtSpilletid.setText(String.valueOf(enFilm.getSpilleTid()));
            txtBeskrivelse.setText(String.valueOf(enFilm.getBeskrivelse()));
            txtUtgivelsesdato.setText(String.valueOf(enFilm.getUtgivelsesDato()));
        }
    }

    public void redigerInfo(ActionEvent actionEvent) throws IOException {
        MainJavaFx mainJavaFx = MainJavaFx.getInstance();
        FilmInfoController.setIndex(valgtFilm);
        mainJavaFx.redigereScene();
    }


    public void lagNyFilm(ActionEvent actionEvent) throws IOException {
        MainJavaFx mainJavaFx = MainJavaFx.getInstance();
        FilmInfoController.setIndex(filmListe.size());
        mainJavaFx.redigereScene();
    }

    public void slettData(ActionEvent actionEvent) {
        DataHandler handler = new DataHandler();
        handler.slettDataene(valgtFilm);
    }
}


