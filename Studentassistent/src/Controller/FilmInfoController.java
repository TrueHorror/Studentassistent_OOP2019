package no.hiof.sclarsen.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import no.hiof.sclarsen.Data.DataHandler;
import no.hiof.sclarsen.MainJavaFx;
import javafx.event.ActionEvent;
import no.hiof.sclarsen.Modell.Film;


import java.io.IOException;
import java.time.LocalDate;

public class FilmInfoController {
    @FXML
    private TextField txtSpilletid;
    @FXML
    private TextField txtTittel;
    @FXML
    private TextArea txtBeskrivelse;
    @FXML
    private DatePicker datoUtgivelse;
    private ObservableList<Film> filmListe;
    private static int valgtFilm = 0;

    public static void setIndex(int x) {
        valgtFilm = x;
    }

    public void initialize(){
        filmListe = DataHandler.hentFilmData();
        if (valgtFilm < filmListe.size()) {
            Film enFilm = filmListe.get(valgtFilm);
            fyllUtInfo(enFilm);
        }
    }
    public void fyllUtInfo(Film film){
        if (film != null) {
            txtTittel.setText(String.valueOf(film.getTittel()));
            txtSpilletid.setText(String.valueOf(film.getSpilleTid()));
            txtBeskrivelse.setText(String.valueOf(film.getBeskrivelse()));
            datoUtgivelse.setValue(LocalDate.from(film.getUtgivelsesDato()));
        }
    }


    public void lagreData(ActionEvent actionEvent) throws IOException {
        MainJavaFx mainJavaFx = MainJavaFx.getInstance();
        lagreDataInntastet();
        mainJavaFx.hovedscene();
    }

    private void lagreDataInntastet() {
        if (valgtFilm <filmListe.size()){
            Film film = filmListe.get(valgtFilm);
            film.setTittel(txtTittel.getText());
            film.setBeskrivelse(txtBeskrivelse.getText());
            film.setSpilleTid(Integer.parseInt(txtSpilletid.getText()));
            film.setUtgivelsesDato(datoUtgivelse.getValue());
        }
        else {
            Film filmX = new Film(txtTittel.getText(), Integer.parseInt(txtSpilletid.getText()), txtBeskrivelse.getText(), datoUtgivelse.getValue());
            DataHandler handler = new DataHandler();
            handler.leggTilData(filmX);

        }
    }


    public void avbrytData(ActionEvent actionEvent) throws IOException {
        MainJavaFx mainJavaFx = MainJavaFx.getInstance();
        mainJavaFx.hovedscene();
    }
}
