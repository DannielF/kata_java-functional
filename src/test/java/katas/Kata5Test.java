package katas;

import model.Movie;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata5Test {

    @Test
    public void testExecute() {

        List<Movie> movies = DataUtil.getMovies();

        var largestRating = movies.stream()
                .reduce((ele1, ele2) -> ele1.getRating() > ele2.getRating() ? ele1 : ele2)
                .map(Movie::getRating)
                .get();

        Assert.assertThat(largestRating, equalTo(5.0));
    }
}
