package com.projpoo;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class Busca {

    public static void main(String[] args) {
        TmdbSearch buscador = new TmdbSearch(new TmdbApi("2b101da85c41bf5cb1ce101ebb69b33c"));
        MovieResultsPage searchMovies = new MovieResultsPage();
        searchMovies = buscador.searchMovie("Thor", 0, "pt-br", false, 0);

        MovieResultsPage popMovies = new MovieResultsPage();
    }

}