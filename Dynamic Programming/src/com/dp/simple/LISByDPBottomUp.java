package com.dp.simple;

import java.util.ArrayList;
import java.util.List;

public class LISByDPBottomUp {
    static List<Integer> findLIS(int[] arr) {
        List<List<Integer>> cache = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cache.add(new ArrayList<>());
        }

        cache.get(0).add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && cache.get(i).size() < cache.get(j).size() + 1) {
                    cache.set(i, new ArrayList<>(cache.get(j)));
                }
            }
            cache.get(i).add(arr[i]);
        }

        List<Integer> longest = cache.get(0);
        for (int i = 0; i < cache.size(); i++) {
            if (longest.size() < cache.get(i).size()) {
                longest = new ArrayList<>(cache.get(i));
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 8, 9, 21, 41, 50, 60};
        System.out.println("LIS: " + findLIS(arr).toString());
    }
}
