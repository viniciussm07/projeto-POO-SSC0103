package com.projpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController {

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoMinhaLista;

    @FXML
    private HBox hboxFilms;

    @FXML
    private Button plus;

    public void switchToMinhaLista(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/minhaListaLayout.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void plusPane(ActionEvent event) {
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #000000;");
        pane1.setPrefHeight(164.0);
        pane1.setPrefWidth(121.0);
        
        Pane pane2 = new Pane();
        pane2.setStyle("-fx-background-color: #ffffff;");
        hboxFilms.getChildren().addAll(pane1, pane2);
        // prefHeight="164.0" prefWidth="121.0" style="-fx-background-color: #D9D9D9;
        System.out.println(hboxFilms.getChildren());
    }



}