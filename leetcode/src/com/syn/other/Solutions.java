package com.syn.other;


public class Solutions {
    //1。给定一个无序数组，求如果数组排好序后，相邻两数的最大差值，要求时间复杂度O(n)
    public int consecutiveMaxValue(int[] arr) {
        //处理数组长度小于等于2的时候
        if (arr == null || arr.length < 2) {
            return 0;
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]) - Math.min(arr[0], arr[1]);
        }
        //构造桶
        int[][] barrelArr = getBarrelArr(arr);
        if (barrelArr == null) {
            return 0;
        }
        //查出相邻桶的最大差值
        int diffValueMax = 0;

        for (int i = 1; i < barrelArr.length; i++) {
            int diff = barrelArr[i - 1][1] - barrelArr[i][0];
            if (diff < diffValueMax) {
                diffValueMax = diff;
            }
        }
        return diffValueMax;
    }

    private int[][] getBarrelArr(int[] arr) {
        int[][] barrelArr = null;
        int max = arr[0];
        int min = arr[1];
        //找出最大值和最小值
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int N = arr.length;
        double barrelArrCapacity = (double) (max - min) / (N + 1);//桶的容量
        barrelArr = new int[N+1][2];
        //把最小值和最大值翻去桶中
        barrelArr[0][0] = min;
        barrelArr[barrelArr.length - 1][1] = max;


        //把值放入桶中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==max){
                continue;
            }
            if (arr[i]==min){
                continue;
            }
            int barrIndex =(int) ((double)(arr[i] - min) / barrelArrCapacity);
            //将当前值和桶中的值比较
            int barrelMin = barrelArr[barrIndex][0];
            int barrelMax = barrelArr[barrIndex][1];
            if (barrelMin > min && barrelMin > arr[i]) {
                barrelArr[barrIndex][0] = arr[i];
                continue;
            }
            if (barrelMax < arr[i]) {
                barrelArr[barrIndex][1] = arr[i];
                continue;
            }
        }
        return barrelArr;

    }
}
