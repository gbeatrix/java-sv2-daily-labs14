package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    // Add vissza azon filmek listáját amiben szerepel egy paraméterül átadott színész.
    public List<Movie> getMoviesWithActor(String actor){
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .toList();
    }

    // Add vissza a leghosszabb film hosszát
    public int getLongestLength(){
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("empty list"));
    }
}
