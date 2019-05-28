package com.algorithm.problems;

import java.util.*;

public class LRUCache {

    private int size;
    private Deque<Integer> deque;
    private Set<Integer> map;

    public LRUCache(int size) {
        this.size = size;
        deque = new LinkedList<>();
        map = new HashSet<>();
    }

    public void add(int val) {
        if (!map.contains(val)) {
            if (deque.size() == size) {
                map.add(val);
                deque.push(val);
            }
        } else {
            int index = 0, i = 0;
            Iterator<Integer> iterator = deque.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == val) {
                    index = i;
                    break;
                }
                i++;
            }

            deque.remove(index);
        }
        deque.push(val);
        map.add(val);
    }
}
