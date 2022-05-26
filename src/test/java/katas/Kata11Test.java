package katas;

import org.junit.Test;
import util.DataUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class Kata11Test {

    @Test
    public void testExecute() {

        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();

        var newList = lists.stream()
                .map(list -> Map.of("name", list.get("name"),
                        "videos", videos
                                .stream()
                                .filter(video -> video.get("listId")
                                        .equals(list.get("id")))
                                .map(video -> Map.of("id", video.get("id"), "title", video.get("title"),
                                        "time", bookmarkList
                                                .stream()
                                                .filter(bookM -> bookM.get("videoId")
                                                        .equals(video.get("id")))
                                                .map(book -> book.get("time")).toList(),
                                        "boxArt", boxArts.stream()
                                                .filter(boxA -> boxA.get("videoId")
                                                        .equals(video.get("id")))
                                                .min(Comparator.comparingInt(box -> (int) box.get("width")))))
                                .toList()))
                .toList();

        assertThat(newList.size(), equalTo(2));
    }
}
