package com.projpoo;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class Busca {

    static String apiKey = ApiKey.key;

    public static List<MovieDb> filme(String nomeFilme) {
        TmdbSearch buscador = new TmdbSearch(new TmdbApi(apiKey));
        MovieResultsPage searchMovies = new MovieResultsPage();
        try {
            searchMovies = buscador.searchMovie(nomeFilme, 0, "pt-br", false, 0);    
            return searchMovies.getResults();
        } catch (RuntimeException e) {
            //System.out.println("Campo de busca vazio!");
            return searchMovies.getResults(); 
        }
    }

    public static void main(String[] args) {
        List<MovieDb> rsultado = Busca.filme("");
        
        int cont = 5;
        if (rsultado != null) {
            for (MovieDb movieDb : rsultado) {
                System.out.println(movieDb.getTitle());
                cont--;
                if (cont == 0) break;
            }
        } else
            System.out.println("A busca não encoutrou filmes!");
        
    }

}