package edu.ics211.h06;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(0, 0);

        arr.add("a");
        arr.add("c");
        arr.add(0,"b");
        arr.add("d");
        arr.add(0,"e");
        System.out.println(arr.toString());

        System.out.println(arr.get(3));
        System.out.println(arr.get(0));

        //arr.print();
        
    }

}
