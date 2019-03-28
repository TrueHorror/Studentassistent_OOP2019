package hiof.no.Oblig4.controller;

import hiof.no.Oblig4.Data.DataHandler;
import hiof.no.Oblig4.model.Film;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

public class NyFilmController {

    @FXML
    private Button lagre;

    @FXML
    private Button slett;

    @FXML
    private TextField redTittel;

    @FXML
    private TextArea redBeskrivelse;

    @FXML
    private DatePicker redUtgivelsesdato;

    @FXML
    private TextField redSpilletid;

    @FXML
    private ObservableList<Film> lagreEndringIListe;

    @FXML
    private ListView<Film> visningsListe;

    @FXML
    public Film valgtFilm;

    @FXML
    public int index;

    @FXML
    public AnchorPane NyttVindu;



    @FXML
    public void initialize() {

    }

    public void leggTilNyFilm(){

        lagreEndringIListe = DataHandler.hentFilmData();



        double nySpilleTid = Double.parseDouble(redSpilletid.getText());

        int sisteIndex = lagreEndringIListe.size();

        valgtFilm = new Film(redTittel.getText(),redBeskrivelse.getText(),nySpilleTid,redUtgivelsesdato.getValue());

        DataHandler.hentFilmData().add(sisteIndex,valgtFilm);


        Window stage = NyttVindu.getScene().getWindow();

        stage.hide();


    }

}
