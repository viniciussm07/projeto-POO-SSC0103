package com.projpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

import com.projpoo.ApiKey;
import com.projpoo.api.Filme;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
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

    public void loopAdd(HBox hbox, Filme[] listafilmes, int i) {
        Pane pane;
        do {
            System.out.println("primeiro loop" + i);
            pane = createPane(listafilmes[i].URL);
            if (i % 4 == 0 && i != 0) {
                hbox = createHbox();
                if (i != 0) {
                    anchorRoot.getChildren().addAll(hbox);
                }
            } else {
                hbox.getChildren().addAll(pane);
            }
            i++;
        } while (i % 4 != 3);
    }

    @FXML
    void adding(ActionEvent event) {
        HBox hbox1 = createHbox();
        HBox hbox2 = createHbox();
        HBox hbox3 = createHbox();
        HBox hbox4 = createHbox();
        HBox hbox5 = createHbox();

        Filme[] listaFilmes = getFilme();

        for (int i = 0; i < listaFilmes.length; i += 4) {
            switch (i) {
                case 0:
                    loopAdd(hbox1, listaFilmes, i);
                    break;
                case 4:
                    loopAdd(hbox2, listaFilmes, i);
                    break;
                case 8:
                    loopAdd(hbox3, listaFilmes, i);
                    break;
                case 12:
                    loopAdd(hbox4, listaFilmes, i);
                    break;
                case 16:
                    loopAdd(hbox5, listaFilmes, i);
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    Pane createPane(String imagem) {
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-image: url(" + imagem
                + ");-fx-background-repeat: no-repeat;-fx-background-size: 174 166;-fx-background-position: center center;");
        HBox.setMargin(pane1, new Insets(0, 25, 0, 25));
        pane1.setPrefWidth(135.0);

        return pane1;
    }

    @FXML
    HBox createHbox() {
        HBox hbox = new HBox();
        hbox.setLayoutY(94.0);
        hbox.setPrefSize(640.0, 166.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setLeftAnchor(hbox, 0.0);

        return hbox;
    }

    // Carregar filmes
    public static String apiKey = ApiKey.key;
    public static String baseURL = "https://image.tmdb.org/t/p/";

    Filme[] getFilme() {

        Filme[] vetorFilme = new Filme[20];
        int contador = 0;

        TmdbApi apiObj = new TmdbApi(apiKey);
        TmdbMovies movies = apiObj.getMovies();

        MovieResultsPage popMovies = new MovieResultsPage();
        popMovies = movies.getPopularMovies("pt-br", 1);

        List<MovieDb> lista = popMovies.getResults();

        for (MovieDb movieDb : lista) {

            vetorFilme[contador] = new Filme(movieDb.getTitle(), baseURL + "original" + movieDb.getPosterPath(),
                    movieDb.getReleaseDate(), movieDb.getOverview());
            contador++;
            // System.out.println(baseURL + "original" + movieDb.getPosterPath());
        }

        return vetorFilme;
    }

}