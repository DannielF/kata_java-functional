package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    private Kata4() {
    }

    public static List<Map<String, Object>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(list -> list.getVideos().stream()
                        .map(video ->
                                Map.of("id ", video.getId(),
                                        "title ", video.getTitle(),
                                        "boxArt ", video.getBoxarts().stream()
                                                .filter(ele -> ele.getWidth() == 150).toList())))
                .toList();
    }
}
