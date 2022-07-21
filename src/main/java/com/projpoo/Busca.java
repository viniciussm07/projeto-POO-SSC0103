package com.projpoo;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class Busca {

    static String apiKey = "2b101da85c41bf5cb1ce101ebb69b33c";

    public static void filme(String nomeFilme) {
        TmdbSearch buscador = new TmdbSearch(new TmdbApi(apiKey));
        MovieResultsPage searchMovies = new MovieResultsPage();
        try {
            searchMovies = buscador.searchMovie(nomeFilme, 0, "pt-br", false, 0);    
        } catch (RuntimeException e) {
            System.out.println("Campo de busca vazio!");
            return;
        }
        

        for (MovieDb movieDb : searchMovies.getResults()) {
            System.out.println(movieDb.getTitle());
        }
    }

    public static void main(String[] args) {
        
        
    }

}