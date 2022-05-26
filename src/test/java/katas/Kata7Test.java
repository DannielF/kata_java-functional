package katas;

import model.BoxArt;
import model.MovieList;
import org.junit.Test;
import util.DataUtil;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata7Test {

    @Test
    public void testExecute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        var newList = movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
                .map(video -> Map.of("id", video.getId(),
                        "title", video.getTitle(),
                        "boxArt", video.getBoxarts().stream()
                                .filter(boxArt -> boxArt.getWidth() <= 150)
                                .map(BoxArt::getUrl).toList())).toList();

        assertThat(newList.size(), equalTo(4));
    }
}
