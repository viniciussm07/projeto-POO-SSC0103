package com.projpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {
            // Carrega telas
            Parent root = FXMLLoader.load(getClass().getResource("views/loginLayout.fxml"));
            Scene login = new Scene(root);
    
            stage.setTitle("Cine List");
            stage.setScene(login);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static void changeToHome() throws IOException{
    //     FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("homeLayout.fxml"));
    //     Parent teste = homeLoader.load();
    //     Scene home = new Scene(teste);

    //     window.setScene(home);
    // }
}
