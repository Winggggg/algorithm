package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 基数排序
 */
public class RadixSort {

    /*
        基本思想:
        将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，
        依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
        基数排序按照优先从高位或低位来排序有两种实现方案：

        MSD（Most significant digital）  从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录,
        关键码k1相等, 再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组, 直到按最次位关键码kd对各子组排序后. 再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。

        LSD（Least significant digital） 从最右侧低位开始进行排序。先从kd开始排序，再对kd-1进行排序，
        依次重复，直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。

        算法描述
        以LSD为例，从最低位开始，具体算法描述如下：
        ①. 取得数组中的最大数，并取得位数；
        ②. arr为原始数组，从最低位开始取每个位组成radix数组；
        ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；

        代码实现
        基数排序：通过序列中各个元素的值，对排序的N个元素进行若干趟的“分配”与“收集”来实现排序。
        分配：我们将L[i]中的元素取出，首先确定其个位上的数字，根据该数字分配到与之序号相同的桶中
        收集：当序列中所有的元素都分配到对应的桶中，再按照顺序依次将桶中的元素收集形成新的一个
        待排序列L[]。对新形成的序列L[]重复执行分配和收集元素中的十位、百位…直到分配完该序列中的最高位，
        则排序结束

     */

    public static void main(String[] args) {
        int[] array = {5, 94, 133, 12, 1111, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void sort(int []array){
        if (array==null||array.length==0){
            return;
        }

        //找到数组最大值
        int max=array[0];
        for (int i = 1; i <array.length ; i++) {
            if (array[i]>max){
                max=array[i];
            }
        }

        //根据最大值判断有多少位数，遍历多少次
        for (int i = 1; max/i >0 ; i=i*10) {
            //排序array.length行10列
            int[][] buckets=new int[array.length][10];
            for (int j = 0; j <array.length ; j++) {
                int num=(array[j]/i)%10;
                buckets[j][num]=array[j];
            }

            //重新回收桶内元素
            int k=0;
            //有10个桶
            for (int j = 0; j < 10; j++) {
                //堆桶内每个元素进行遍历
                for (int l = 0; l <array.length ; l++) {
                    if (buckets[l][j]!=0){
                        array[k++]=buckets[l][j];
                    }
                }
            }
        }
    }

}
