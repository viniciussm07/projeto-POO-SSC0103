package com.projpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene login, home;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // Carrega telas
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("views/loginLayout.fxml"));
        Parent root = loginLoader.load();
        Scene login = new Scene(root);

        window.setTitle("Login");
        window.setScene(login);
        window.show();
    }

    // public static void changeToHome() throws IOException{
    //     FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("homeLayout.fxml"));
    //     Parent teste = homeLoader.load();
    //     Scene home = new Scene(teste);

    //     window.setScene(home);
    // }
}
