package hiof.no.Oblig4.controller;

import hiof.no.Oblig4.Data.DataHandler;
import hiof.no.Oblig4.model.Film;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;



public class Redcontroller {

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
    public Film valgtFilm;

    @FXML
    public int index;

    @FXML
    public AnchorPane redigerVindu1;




    @FXML
    public void initialize() {

    }

    public void fyllUtFilmInfo(String redTittel, String redBeskrivelse, String redUtgivelsesdato, String redSpilletid,int index){


           this.redTittel.setText(redTittel);
           this.redBeskrivelse.setText(redBeskrivelse);
           this.redUtgivelsesdato.setPromptText(redUtgivelsesdato);
           this.redSpilletid.setText(redSpilletid);
           this.index = index;


    }




   public void lagreFilmen(){

        lagreEndringIListe = DataHandler.hentFilmData();

        valgtFilm = lagreEndringIListe.get(index);

        valgtFilm.setEpisodeTittel(redTittel.getText());
        valgtFilm.setBeskrivelse(redBeskrivelse.getText());
        valgtFilm.setUtgivelsesDato(redUtgivelsesdato.getValue());
        valgtFilm.setSpilleTid(Double.parseDouble(redSpilletid.getText()));

        Window stage = redigerVindu1.getScene().getWindow();

        stage.hide();


    }





}




















