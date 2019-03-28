package hiof.no.Oblig4;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainJavaFX extends Application {

    private static MainJavaFX varapplikasjon;

    private Stage primaryStage;


    public MainJavaFX() {

        varapplikasjon = this;

    }


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        try{

        FXMLLoader FXMLoader = new FXMLLoader(getClass().getResource("view/Filmer.fxml"));

        Parent root = FXMLoader.load();


        Scene hovedScene = new Scene(root, 1000, 800);
        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Film Liste");
        primaryStage.show();

    }
        catch(IOException e) {

        e.printStackTrace();

    }

}

    public static void main(String[] args) {

        Application.launch(args);

    }



}




























