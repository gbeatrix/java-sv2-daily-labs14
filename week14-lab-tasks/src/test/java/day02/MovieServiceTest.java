package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    @Test
    void testMovieService(){
        MovieService movieService = new MovieService();
        Movie m1 = new Movie("Ilyen nincs", 90, List.of("Gipsz Jakab", "Szikla Szilárd"));
        Movie m2 = new Movie("Ilyen sincs", 100, List.of("Major Anna", "Szikla Szilárd"));
        Movie m3 = new Movie("Ilyen még lehet", 80, List.of("Szikla Szilárd", "Minta Áron"));
        Movie m4 = new Movie("Ilyen lehetett volna", 95, List.of("Gipsz Jakab", "Minta Áron"));
        movieService.addMovie(m1);
        movieService.addMovie(m2);
        movieService.addMovie(m3);
        movieService.addMovie(m4);

        assertEquals(100, movieService.getLongestLength());
        assertEquals(List.of(m1, m2, m3), movieService.getMoviesWithActor("Szikla Szilárd"));
    }
}