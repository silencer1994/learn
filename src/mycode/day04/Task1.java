package mycode.day04;

import java.util.Arrays;

/**
 * Created by ls on 17-7-3.
 * 数组获取最值(获取数组中的最大值最小值)
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr = {8, 2134, 53, 35434, 131423, 1324123, 20, 11, 91212, 123, 3, 231234};
//        sortBubbling(arr);
//        sortInsert(arr);
        sortFast(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param numbers 格式化
     */
    private static void sortFast(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
//        return low ; // 返回中轴的位置
        System.out.println(Arrays.toString(numbers));

    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void sortInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println
                (Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void sortBubbling(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
