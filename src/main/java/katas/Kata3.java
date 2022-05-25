package katas;

import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {

    private Kata3() {
    }

    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream().map(Movie::getId))
                .toList();
    }
}
