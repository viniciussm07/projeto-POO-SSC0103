package com.projpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController {

    @FXML
    private AnchorPane anchorRoot;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoMinhaLista;

    @FXML
    private Button carregaFilmes;

    public void switchToMinhaLista(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/minhaListaLayout.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void adding(ActionEvent event) {
        HBox hbox = addHbox();
        Pane pane = createPane();
        hbox.getChildren().addAll(pane);
        anchorRoot.getChildren().addAll(hbox);
    }

    // @FXML
    // ImageView addFilmImage() {
    //     ImageView filmImage = new ImageView();
    //     filmImage.setFitHeight(164.0);
    //     filmImage.setFitWidth(121.0);
    //     filmImage.setPickOnBounds(true);
    //     filmImage.setPreserveRatio(true);
    //     // altrerar a linha de baixo e adicionar a função para puxar a imagem da api
    //     Image img = new Image(
    //             "https://disney.com.br/novidades/quando-doutor-estranho-no-multiverso-da-loucura-estreia-no-disney-plus");

    //     filmImage.setImage(img);

    //     System.out.println("testando");

    //     return filmImage;
    // }

    @FXML
    Pane createPane() {
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-image: url('https://lumiere-a.akamaihd.net/v1/images/beta_epic_payoff_brazil_2a5f625f.jpeg');-fx-background-repeat: no-repeat;-fx-background-size: 174 166;-fx-background-position: center center;");
        HBox.setMargin(pane1, new Insets(0, 25, 0, 25));
        pane1.setPrefWidth(135.0);

        return pane1;
    }

    @FXML
    HBox addHbox() {
        HBox hbox = new HBox();
        hbox.setLayoutY(94.0);
        hbox.setPrefSize(640.0, 166.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setLeftAnchor(hbox, 0.0);

        return hbox;
    }

}