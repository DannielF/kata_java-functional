package katas;

import model.BoxArt;
import model.InterestingMoment;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

    private Kata9() {
    }

    public static List<Map<String, Object>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().flatMap(list -> list.getVideos().stream())
                .map(movie -> Map.of("id", movie.getId(),
                        "title", movie.getTitle(),
                        "time", movie.getInterestingMoments()
                                .stream().map(InterestingMoment::getTime)
                                .toList(),
                        "url", movie.getBoxarts().stream()
                                .filter(boxArt -> boxArt.getWidth() <= 150)
                                .map(BoxArt::getUrl).toList())).toList();
    }
}
