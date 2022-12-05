package com.mrfang.yunhome.utils;

import com.mrfang.yunhome.service.ITenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/18 16:13
 * @ Project: RuoYi
 */
public class Demo1 {



    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
        //    public static List<Integer> findCommon(int[] arr1, int[] arr2) {
        //    List<Integer> list = new ArrayList<>();
        //    if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
        //        return list;
        //    }
        //    Arrays.sort(arr1);
        //    Arrays.sort(arr2);
        //    int i = 0, j = 0;
        //    while ( i < arr1.length && j < arr2.length ) {
        //        if (arr1[i] == arr2[j]) {
        //            list.add(arr1[i]);
        //            i++;
        //            j++;
        //        }
        //        else if (arr1[i] < arr2[j]) i++;
        //        else j++;
        //    }
        //    return list;
        //}

        //String ids= "2,3,4";
        //int[] arr1=new int[ids.split(",").length];
        //for (int i=0;i<ids.split(",").length;i++){
        //    arr1[i]= Integer.valueOf(ids.split(",")[i]);
        //}
        //List<Integer> list = new ArrayList<>();
        //
        //System.out.println(list);
        //System.out.println(Arrays.toString(arr1));

        //System.out.println(ids.split(",")[0]);
        //System.out.println(ids.split(",")[1]);
        //System.out.println(ids.split(",")[2]);
        //System.out.println(ids.split(",").length);
    }
}
