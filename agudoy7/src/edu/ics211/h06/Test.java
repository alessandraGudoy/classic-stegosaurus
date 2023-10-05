package edu.ics211.h06;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(1, 0);

        System.out.println(arr.capacity());
        System.out.println(arr.add("a"));
        System.out.println(arr.capacity());
        
    }

}
