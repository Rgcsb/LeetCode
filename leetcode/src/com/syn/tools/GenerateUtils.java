package com.syn.tools;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class GenerateUtils {

    public static int[] generateArr(int len,int max) {
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }
}
