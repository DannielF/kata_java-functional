package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

    private Kata5() {
    }

    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .reduce((ele1, ele2) -> ele1.getRating() > ele2.getRating() ? ele1 : ele2)
                .map(Movie::getRating)
                .get();
    }
}
