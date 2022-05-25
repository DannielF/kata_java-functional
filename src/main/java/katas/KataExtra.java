package katas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KataExtra {


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        List<List<Integer>> f = new ArrayList<>();
        f.add(a);
        f.add(b);
        List<List<List<Integer>>> d = new ArrayList<>();
        d.add(f);
        d.add(f);

        List<Integer> newD = d.stream()
                .flatMap(Collection::stream)
                .flatMap(List::stream)
                .toList();


        System.out.println("newD" + newD);
    }
}
