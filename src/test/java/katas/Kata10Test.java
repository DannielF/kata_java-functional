package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import org.junit.Assert;
import org.junit.Test;
import util.DataUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata10Test {

    @Test
    public void testExecute() {

        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        var nw = lists.stream().map(list ->  Map.of("name", list.get("name"),
                        "videos", videos.stream()
                                .filter(video -> video.get("listId").equals(list.get("id")))
                                        .map(video -> Map.of("id", video.get("id"),
                                                "title", video.get("title")))
                                                .toList()))
                        .toList();

        assertThat(nw.size(), equalTo(2));
    }
}
