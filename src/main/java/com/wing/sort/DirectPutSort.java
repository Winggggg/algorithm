package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 直接插入算法
 */
public class DirectPutSort {

    /*
        直接插入排序的基本思想是：将数组中的所有元素依次跟前面已经排好的元素相比较，
        如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止。

        一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
        ①. 从第一个元素开始，该元素可以认为已经被排序
        ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
        ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
        ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
        ⑤. 将新元素插入到该位置后
        ⑥. 重复步骤②~⑤

        例子
        6,5,3,1,8,7,2,4
        步骤
        ① 选下标第二位 5 比较6 结果 5,6,3,1,8,7,2,4
        ② 选下标第三位 3 从后往前比较5,6 结果3,5,6,1,8,7,2,4
        ③ 选下标第四位 1 从后往前比较3,5,6 结果1,3,5,6,8,7,2,4
        ④ 选下标第五位 8 从后往前比较1,3,5,6 结果1,3,5,6,8,7,2,4
        ⑤ 选下标第六位 7 从后往前比较1,3,5,6,8 结果1,3,5,6,7,8,2,4
        ⑥ 选下标第七位 2 从后往前比较1,3,5,6,7,8 结果1,2,3,5,6,7,8,4
        ⑦ 选下标第八位 4 从后往前比较1,2,3,5,6,7,8 结果1,2,3,4,5,6,7,8

        时间复杂度 (以升序为列)
        最好O(n)   数组{0,1,2,3,4,5} 变成 {0,1,2,3,4,5}
        最坏O(n*n) 数组{5,4,3,2,1,0} 变成 {0,1,2,3,4,5}
        空间复杂度O(1)

    */

    public static void sort(int []array){
        if (array==null||array.length==0){
            return;
        }

        for (int i = 1; i <array.length ; i++) {
            int j=i-1;
            int temp=array[i];
            while (j>=0&&array[j]>temp){
                array[j+1]=array[j];
                j--;
            }
           array[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {6,5,3,1,8,7,2,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


}

