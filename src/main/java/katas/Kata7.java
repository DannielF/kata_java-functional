package katas;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

    private Kata7() {
    }

    public static List<Map<String, Object>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();


        return movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
                .map(video -> Map.of("id", video.getId(),
                        "title", video.getTitle(),
                        "boxArt", video.getBoxarts().stream()
                                .filter(boxArt -> boxArt.getWidth() <= 150)
                                .map(BoxArt::getUrl).toList())).toList();
    }
}
