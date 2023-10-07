package edu.ics211.h06;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(4, -1);

        System.out.println(arr.capacity());
        System.out.println(arr.add("a"));
        System.out.println(arr.add("b"));
        System.out.println(arr.add("c"));
        System.out.println(arr.add("d"));
        
        System.out.println(arr.toString());
        arr.add(0,"e");
        System.out.println(arr.toString());
        //arr.print();
        
    }

}
