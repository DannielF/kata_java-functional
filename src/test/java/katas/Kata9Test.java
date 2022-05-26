package katas;

import model.BoxArt;
import model.InterestingMoment;
import model.MovieList;
import org.junit.Test;
import util.DataUtil;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata9Test {

    @Test
    public void testExecute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        var newList = movieLists.stream().flatMap(list -> list.getVideos().stream())
                .map(movie -> Map.of("id", movie.getId(),
                        "title", movie.getTitle(),
                        "time", movie.getInterestingMoments()
                                .stream().map(InterestingMoment::getTime)
                                .toList(),
                        "url", movie.getBoxarts().stream()
                                .filter(boxArt -> boxArt.getWidth() <= 150)
                                .map(BoxArt::getUrl).toList())).toList();

        assertThat(newList.size(), equalTo(4));
    }
}
