package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 冒泡排序  https://juejin.im/post/5b95da8a5188255c775d8124#heading-40
 */
public class BubbleSort {

    /*
    冒泡排序算法的算法过程如下：
    ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
    ③. 针对所有的元素重复以上的步骤，除了最后一个。
    ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
    *

    时间复杂度 (以升序为列)
    最好O(n)   数组{0,1,2,3,4,5} 变成 {0,1,2,3,4,5}
    最坏O(n*n) 数组{5,4,3,2,1,0} 变成 {0,1,2,3,4,5}
    空间复杂度O(1)
   */

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        //外层：需要length-1次循环比较
        for (int i = 0; i < array.length - 1; i++) {
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //交换数组array的j和j+1位置的数据
                    swapByBitOperation(array, j, j + 1);
                }
            }
        }
    }


    /**
     * 交换两个坐标的数据 (通过临时变量交换)
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swapByTemp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 交换两个坐标的数据 (通过算法交换)
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swapByAlgorithm(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    /**
     * 交换两个坐标的数据 (通过位移法交换)
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swapByBitOperation(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }


}
