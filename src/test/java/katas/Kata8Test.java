package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.Movie;
import org.junit.Test;
import util.DataUtil;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata8Test {

    @Test
    public void testExecute() {

        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        var zipped = StreamUtils.zip
                        (movies.stream(), bookMarks.stream(),
                                (a, b) -> Map.of("videoId", a.getId(), "bookMarkId", b.getId()))
                .toList();

        assertThat(zipped.size(), equalTo(3));
    }
}
