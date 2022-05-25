package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {

    private Kata6() {
    }

    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        var urlLargestBoxArt = movies.stream()
                .flatMap(movie -> movie.getBoxarts().stream())
                .reduce((a, b) -> a.getWidth() > b.getWidth() ? a : b)
                .map(BoxArt::getUrl);

        if (urlLargestBoxArt.isPresent()) {
            return urlLargestBoxArt.toString();
        }
        return "";
    }
}
