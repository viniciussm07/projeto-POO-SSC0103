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
        TmdbApi apiObj = new TmdbApi(apiKey);
        TmdbMovies movies = apiObj.getMovies();

        //movies.getSimilarMovies(movieId, language, page)
        MovieResultsPage popMovies = new MovieResultsPage();
        popMovies = movies.getPopularMovies("pt-br", 1);
        //popMovies = 
        List<MovieDb> lista = popMovies.getResults();
        lista.add(movies.getMovie(144, "en"));
        //popMovies.
        for (MovieDb movieDb : lista) {
            
            System.out.println(movieDb.getTitle());
            System.out.println(baseURL + "original" + movieDb.getPosterPath());
        }
    }
}
