package com.projpoo;
import java.util.List;

import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
/**
 * Hello world!
 *
 */
public class App 
{
    public static String apiKey = "2b101da85c41bf5cb1ce101ebb69b33c";
    public static String baseURL = "https://image.tmdb.org/t/p/";
    public static void main( String[] args )
    {
        TmdbMovies movies = new TmdbApi(apiKey).getMovies();
        MovieDb movie = movies.getMovie(5353, "en");
        System.out.println(movie.getOriginalTitle());
        MovieResultsPage popMovies = new MovieResultsPage();
        popMovies = movies.getPopularMovies("en", 1);
        List<MovieDb> lista = popMovies.getResults();
        //popMovies.
        for (MovieDb movieDb : lista) {
            System.out.println(movieDb.getOriginalTitle());
            System.out.println(baseURL + "original" + movieDb.getPosterPath());
        }
        System.out.println( "Hello World!" );
    }
}
