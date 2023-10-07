package edu.ics211.h06;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(0, 1);

        arr.add("a");
        arr.add("c");
        arr.add(1,"b");
        arr.add("d");
        arr.add(1,"e");
        System.out.println(arr.toString());

        System.out.println(arr.set(0, "B"));
        System.out.println(arr.toString());

        //arr.print();
        
    }

}
