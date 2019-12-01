package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 希尔排序  https://juejin.im/post/5b95da8a5188255c775d8124#heading-32
 */
public class ShellSort {

    /*
        希尔排序，也称递减增量排序算法，1959年Shell发明。是插入排序的一种高速而稳定的改进版本。

        希尔排序是先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录
        “基本有序”时，再对全体记录进行依次直接插入排序。

        基本思想:
        将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
        每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
        可以看到步长的选择是希尔排序的重要部分。只要最终步长为1任何步长序列都可以工作。
        一般来说最简单的步长取值是初次取数组长度的一半为增量，之后每次再减半，直到增量为1。
        更好的步长序列取值可以参考维基百科。

        算法描述
        ①. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
        ②. 按增量序列个数k，对序列进行k 趟排序；
        ③. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，
            整个序列作为一个表来处理，表长度即为整个序列的长度。


     */

    public static void main(String[] args) {
        int[] array = {6,5,3,1,8,7,2,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array==null||array.length==0){
            return;
        }
        //初始步长
        int gap = array.length / 2;
        for (; gap > 0; gap = gap / 2) {
            for (int i = 0; (i + gap) < array.length; i++) {
                //不断缩小gap，直到1为止
                for (int j = 0; (j + gap) < array.length; j += gap) {
                    //使用当前gap进行组内插入排序
                    if (array[j] > array[j + gap]) {
                        //交换操作
                        swapByTemp(array, j, j + gap);
                    }
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

}
