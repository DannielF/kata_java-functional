package katas;

import model.MovieList;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata4Test {

    @Test
    public void testExecute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        var videos = movieLists.stream()
                .flatMap(list -> list.getVideos().stream()
                        .map(video ->
                                Map.of("id ", video.getId(),
                                        "title ", video.getTitle(),
                                        "boxArt ", video.getBoxarts().stream()
                                                .filter(ele -> ele.getWidth() == 150).toList())))
                .toList();

        Assert.assertThat(videos.size(), equalTo(4));
    }
}
