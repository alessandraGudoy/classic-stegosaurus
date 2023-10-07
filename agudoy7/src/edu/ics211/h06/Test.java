package edu.ics211.h06;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(1, 1);

        arr.add("a");
        arr.add("c");
        arr.add(1,"b");
        arr.add("d");
        arr.add(1,"e");
        System.out.println(arr.toString());

        System.out.println(arr.remove(5));
        System.out.println(arr.remove(4));
        System.out.println(arr.toString());
        System.out.println(arr.size());
        
    }

}
