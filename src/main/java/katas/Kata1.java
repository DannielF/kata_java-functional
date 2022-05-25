package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    private Kata1() {
    }

    public static List<Map<Integer, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().map(ele -> Map.of(ele.getId(), ele.getTitle())).collect(Collectors.toList());
    }
}
