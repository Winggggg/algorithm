package com.wing.sort;

import java.util.Arrays;

/**
 * @author heweiye
 * @version 1.0
 * @Date 2019/11/29.
 * @description 堆排序  https://juejin.im/post/5bea6af051882548161b0f02#heading-1
 */
public class HeapSort {

    /*
        概念
        完全二叉树： 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
        第 h 层所有的结点都连续集中在最左边，这就是完全二叉树

        堆的特征
        堆的数据结构近似完全二叉树，即每个节点存在两个子节点
        当节点的值小于或等于父节点值，大于或等于子节点值称为大顶堆（也即根节点的值最大）
        当节点的值大于或等于父节点值，小于或等于子节点值称为小顶堆（也即根节点的值最小）
        若当前节点的索引为 k , 那么左子节点索引为 2k + 1, 右子节点索引为 2k + 2,
        父节点索引为 (k - 1) / 2


        基本思想
        堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
        将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会
        得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。


     */

    public static void main(String[] args) {
        int[] array = {10, 40, 38, 20, 9, 15, 25, 30, 32};
        sort2(array);
        System.out.println("================"+Arrays.toString(array));
    }

    /**
     * 以上浮方式排序
     * @param array
     */
    public static void sort1(int[] array){
        //构造大顶堆
        for (int i = 0; i <array.length ; i++) {
            siftUp(i,array);
        }

        System.out.println(Arrays.toString(array));

        int n=array.length-1;

        while (n>0){
            //交换首尾元素
            swapByTemp(array,0,n);

            //重新构建大顶堆，排除末尾已排序元素
            for (int i = 0; i <n ; i++) {
                siftUp(i,array);
            }

            System.out.println(Arrays.toString(array));

            n--;
        }
    }


    /**
     * 以下沉建堆方式排序
     * @param array
     */
    public static void sort2(int[] array){
        // 构建堆
        // 因为堆是完全二叉树的特性, 所以下标小于等于 array.length / 2 的节点为非叶子节点
        // 采用下沉的方式 从下往上构建子堆
        for (int i = array.length/2; i >=0 ; i--) {
            siftDown(i,array.length,array);
        }

        System.out.println(Arrays.toString(array));

        int n=array.length-1;

        while (n>0){
            //交换首尾元素
            swapByTemp(array,0,n);

            //重新构建大顶堆，排除末尾已排序元素
            for (int i = n/2; i >=0 ; i--) {
                siftDown(i,n,array);
            }

            System.out.println(Arrays.toString(array));

            n--;
        }
    }


    /**
     * 上浮操作 是指在构建堆时，若节点的值大于父节点则将当前节点与父节点互相交换；
     * 直至该节点小于父节点时终止上浮（可以理解为一个新入职的员工能力出众晋升更高的职位）
     * @param k
     */
    public static void siftUp(int k,int []array){
        while(k>0){
            //获取父节点索引
            int parent=(k-1)/2;

            //小于父节点时推出上浮操作
            if (array[k]<array[parent]){
                break;
            }

            //交换父节点
            swapByTemp(array,k,parent);

            //改变 k 的指向
            k=parent;
        }
    }

    /**
     * 下沉 ： 是指构建堆的过程中，若当前节点值小于子节点则将当前节点与子节点互相交换，直至该节点大于子节点时终止下沉
     * （可以理解为一个leader能力平庸的时候被降职的过程，是不是有点很惨）
     * @param k
     * @param array
     */
    public static void siftDown(int k,int len,int[] array){
        //获取左子节点索引
        int childrenIndex=2*k+1;
        //判断是否存在子节点
        while (childrenIndex<len){
            //判断左右子节点，查找最大子节点
            if (childrenIndex+1<len&&array[childrenIndex]<array[childrenIndex+1]){
                childrenIndex++;
            }

            //大于子节点停止下沉操作
            if (array[k]>array[childrenIndex]){
                break;
            }
            //交换
            swapByTemp(array,k,childrenIndex);

            //改变k的指向
            k=childrenIndex;
            childrenIndex=2*k+1;
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
