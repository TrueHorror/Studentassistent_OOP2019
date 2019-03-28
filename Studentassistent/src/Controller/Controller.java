package hiof.no.Oblig4.controller;

import hiof.no.Oblig4.MainJavaFX;
import hiof.no.Oblig4.model.Film;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import hiof.no.Oblig4.Data.DataHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Button slettButton;

    @FXML
    private Button redigerButton;

    @FXML
    private Button nyButton;

    @FXML
    private Label tittel;

    @FXML
    private TextArea beskrivelsefield;

    @FXML
    private DatePicker utgivelsesdatofield;

    @FXML
    private TextField spilletidfield;

    @FXML
    private ListView<Film> visningListe;


    private Film enFilm;


    private ObservableList<Film> listeMedFilmer;

    private int index;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        listeMedFilmer = DataHandler.hentFilmData();

        visningListe.setItems(DataHandler.hentFilmData());

        getenFilm(listeMedFilmer.get(0));


        visningListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film gammelFilm, Film nyFilm) {
                getenFilm(nyFilm);
                enFilm = nyFilm;

            }
        });


    }

    public void getenFilm(Film filmen) {

        if(filmen != null) {

            tittel.setText(filmen.getTittel());
            beskrivelsefield.setText(filmen.getBeskrivelse());
            utgivelsesdatofield.setPromptText(filmen.getUtgivelsesDato().toString());
            spilletidfield.setText(Double.toString(filmen.getSpilleTid()));

        }



    }



    @FXML
        public void gaaTilRedigerVisning(ActionEvent event) {


        try {


            FXMLLoader loaderinc = new FXMLLoader();

            loaderinc.setLocation(MainJavaFX.class.getResource("view/Rediger.fxml"));

            Parent root = loaderinc.load();


            Redcontroller redigerController = loaderinc.getController();

            redigerController.fyllUtFilmInfo(tittel.getText(), beskrivelsefield.getText(), utgivelsesdatofield.getPromptText(), spilletidfield.getText(),visningListe.getSelectionModel().getSelectedIndex());


            Stage redigerStage = new Stage();

            redigerStage.setScene(new Scene(root, 1000, 800));

            redigerStage.initModality(Modality.WINDOW_MODAL);
            redigerStage.setTitle("Rediger Film");
            redigerStage.showAndWait();



        } catch (IOException e) {
            e.printStackTrace();

        }


    }



    public void nyFilm(ActionEvent event) {

        try{


            FXMLLoader nyFilmLoader = new FXMLLoader();

            nyFilmLoader.setLocation(getClass().getResource("../view/Ny.fxml"));

            Parent root = nyFilmLoader.load();

            NyFilmController nyFilmController = nyFilmLoader.getController();

            Stage nyFilmVindu = new Stage();


            nyFilmVindu.setScene(new Scene(root,1000,1000));

            nyFilmVindu.initModality(Modality.WINDOW_MODAL);
            nyFilmVindu.setTitle("Legg til ny Film");
            nyFilmVindu.show();






        }
        catch (IOException e) {
            e.printStackTrace();

        }




    }

    public void slettKnapp(ActionEvent event){


        listeMedFilmer = DataHandler.hentFilmData();
        index =  visningListe.getSelectionModel().getSelectedIndex();
        listeMedFilmer.remove(index);

    }

}
















