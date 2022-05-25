package katas;

import model.Movie;
import model.MovieList;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata3Test {

    @Test
    public void testExecute() {

        List<MovieList> movieLists = DataUtil.getMovieLists();

        var moviesIdOnly = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream().map(Movie::getId))
                .collect(Collectors.toList());

        Assert.assertThat(moviesIdOnly.size(), equalTo(4));
    }
}
