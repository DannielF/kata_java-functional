package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {

    private Kata8() {
    }

    public static List<Map<String, Integer>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        // StreamUtils.zip()

        return StreamUtils.zip
                        (movies.stream(), bookMarks.stream(),
                                (a, b) -> Map.of("videoId", a.getId(), "bookMarkId", b.getId()))
                .toList();
    }
}
