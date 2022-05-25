package katas;

import model.Movie;
import org.junit.Test;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class Kata2Test {



    @Test
    public void testExecute() {

        List<Movie> movies = DataUtil.getMovies();

        var moviesRatingGthanFive = movies.stream().map(ele -> ele.getRating().intValue())
                .filter(rating -> rating == 5.0).toList();

        assertThat(moviesRatingGthanFive.get(0), equalTo(5));

    }
}
