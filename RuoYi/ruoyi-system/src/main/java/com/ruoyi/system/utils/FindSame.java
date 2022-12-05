package com.ruoyi.system.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出俩组int[]的相同整数
 * @ Author: Fang
 * @ Date: 2022/11/19 12:18
 * @ Project: RuoYi
 */
public class FindSame {
    public  List<Integer> findCommon(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return list;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) i++;
            else j++;
        }
        return list;
    }
}
