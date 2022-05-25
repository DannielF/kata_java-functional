package katas;

import model.BoxArt;
import model.MovieList;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata7Test {

    @Test
    public void testExecute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        var newList = movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
                .map(video -> Map.of("id", video.getId(),
                        "title", video.getTitle(),
                        "boxArt", video.getBoxarts().stream()
                                        .


        Assert.assertThat(Kata7.execute(), equalTo(4));
    }
}
