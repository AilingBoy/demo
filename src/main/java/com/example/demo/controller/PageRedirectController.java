package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
public class PageRedirectController {
    @RequestMapping(value = "/topage", method = RequestMethod.GET)
    public String pageReirect(@RequestParam String url) {
        return url;
    }

//    public static void main(String[] args) {
////        String str ="asdfas";
////        int i=str.length();
////        System.out.println(i);
//
//        int[] arr = {1, 3, 9, 6, 7, 8, 5};
//        System.out.println(Arrays.toString(arr));
//        int n = arr.length;
//
//        //冒泡排序，相邻两个数之间相互比较，小的往前挪一位
////        for (int i = 0; i < n-1; i++) {
////            for (int j = 0; j < n - i - 1; j++) {
////                if (arr[j] > arr[j + 1]) {
////                    int temp;
////                    temp = arr[j];
////                    arr[j] = arr[j+1];
////                    arr[j+1] = temp;
////                }
////                System.out.println(Arrays.toString(arr));
////            }
////        }
//
//        //选择排序,每次内循环找出最小一个，放在新队列最后位，如此循环
////        for (int i = 0; i < n ; i++) {
////            int min = i;
////            for (int j = i+1; j < n ; j++) {
////                if (arr[j] < arr[min]) {
////                    min = j;
////                }
////                if (min != i) {
////                    int temp;
////                    temp = arr[i];
////                    arr[i] = arr[min];
////                    arr[min] = temp;
////                }
////                System.out.println(min);
////                System.out.println(Arrays.toString(arr));
////            }
////        }
//
//
////        快速排序
//
//        quicksort(arr,0,arr.length-1);
//
//
//
//        System.out.println(Arrays.toString(arr));
//    }
//
//
////    快速排序
//    public static void quicksort(int[] arr, int startIndex, int endIndex){
//        if(startIndex>=endIndex){return;
//        }
//        int num=getIndex(arr,startIndex,endIndex);
//        quicksort(arr,startIndex,num-1);
//        quicksort(arr,num+1,endIndex);
//
//    }
//
//    public static int getIndex(int[] arr, int startIndex, int endIndex){
//        int left=startIndex;
//        int right=endIndex;
//        int priod=arr[startIndex];
//        while(left!=right){
//            while(left<right&&arr[right]>priod){
//                right--;
//            }
//            while(left<right&&arr[left]<=priod){
//                left++;
//            }
//            if(left<right){
//                int temp;
//                temp=arr[left];
//                arr[left]=arr[right];
//                arr[right]=temp;
//            }
//        }
//        arr[startIndex]=arr[left];
//        arr[left]=priod;
//        return left;
//    }
}
