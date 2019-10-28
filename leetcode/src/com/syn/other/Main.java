package com.syn.other;

import com.syn.tools.GenerateUtils;

public class Main {

    public static void main(String[] args) {
       int arr[] =  GenerateUtils.generateArr(10,100);
        Solutions solutions = new Solutions();
       int diff = solutions.consecutiveMaxValue(arr);
       System.out.println(diff);
    }
}
