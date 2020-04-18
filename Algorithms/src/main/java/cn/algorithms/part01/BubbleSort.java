package cn.algorithms.part01;

import java.util.Arrays;

/**
 * 测试冒泡排序 时间复杂度为O(n^2)
 *
 * @author TaoistQu
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 交换数组两位置上的值
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            bubbleSort(arr1);
            ArrayUtil.comparator(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
        int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
        ArrayUtil.printArray(arr);
        bubbleSort(arr);
        ArrayUtil.printArray(arr);
    }
}