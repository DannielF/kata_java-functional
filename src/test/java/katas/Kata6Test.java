package katas;

import model.BoxArt;
import model.Movie;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata6Test {

    @Test
    public void testExecute() {
        List<Movie> movies = DataUtil.getMovies();

        var urlLargestBoxArt = movies.stream()
                .flatMap(movie -> movie.getBoxarts().stream())
                .reduce((a, b) -> a.getWidth() > b.getWidth() ? a : b)
                        .map(BoxArt::getUrl);

        assertThat(urlLargestBoxArt.get(), equalTo("http://cdn-0.nflximg.com/images/2891/Fracture300.jpg"));
    }
}
