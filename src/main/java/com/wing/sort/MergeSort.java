package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 归并排序
 */
public class MergeSort {

    /*
        基本思想
        归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，
        每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

        采用递归法：
        ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
        ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
        ③. 重复步骤②，直到所有元素排序完毕

        时间复杂度 (以升序为列)
        最好O(nlogn)
        最坏O(nlogn)
        空间复杂度O(n)

    */

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] result=sort(array);
        System.out.println(Arrays.toString(result));
    }


    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int num = array.length >> 1;

        int[] left = Arrays.copyOfRange(array, 0, num);
        int[] right = Arrays.copyOfRange(array, num, array.length);
        //递归二分拆分数组，排序再合并
        return mergeTwoArray(sort(left), sort(right));
    }

    /**
     * 合并两个数组
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeTwoArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            //比较排序
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        //递归a数组剩余多出来的待排序的
        while (i < a.length) {
            result[k++] = a[i++];
        }
        //递归b数组剩余多出来的待排序的
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }
}
