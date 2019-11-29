package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 选择排序
 */
public class SelectSort {

    /*
        基本思想
        在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置。
        在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。

        算法描述
        ①. 从待排序序列中，找到关键字最小的元素；
        ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
        ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。

        时间复杂度
        最好O(n*n)
        最坏O(n*n)
        空间复杂度O(1)
     */

    public static void main(String[] args) {
        int[] array = {6,5,3,1,8,7,2,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[]array){
        if (array==null||array.length==0){
            return;
        }
        for (int i = 0; i <array.length ; i++) {
            int min=i;
            for (int j = i+1; j <array.length ; j++) {
                //选出之后待排序中值最小的位置
                if (array[j]<array[min]){
                    min=j;
                }
            }

            if (min!=i){
                //交换
                swapByTemp(array,i,min);
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


}
