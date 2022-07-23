import java.util.List;

import com.projpoo.Busca;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class Main{

    public static void main(String[] args){

        MovieResultsPage popMovies = new MovieResultsPage();
        popMovies = movies.getPopularMovies("pt-br", 1);

        List<MovieDb> lista = popMovies.getResults();

        for (MovieDb movieDb : lista) {
                
            System.out.println(movieDb.getTitle());
            System.out.println(movieDb.getPosterPath());
        }
    }
}