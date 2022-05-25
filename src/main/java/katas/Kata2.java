package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {

    private Kata2() {
    }

    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().map(ele -> ele.getRating().intValue())
                .filter(rating -> rating == 5.0).collect(Collectors.toList());
    }
}
