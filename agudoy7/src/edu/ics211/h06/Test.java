package edu.ics211.h06;

public class Test {
    public static void main(String[] args){
        OffsetArrayList<String> arr = new OffsetArrayList<>(1, 0);

        String[] list = {"a", "b", "c", "d", "e", "f", "g"};

        for(String str : list){
            arr.add(str);
        }
        System.out.println(arr.toString());
        

        OffsetArrayList<String> arr2 = new OffsetArrayList<>(1, 3);
        for(String str : list){
            System.out.println(str);
            arr2.add(3, str);
        }
        System.out.println(arr2.toString());

        OffsetArrayList<String> arr3 = new OffsetArrayList<>(0, -4);
        for(int i=0; i<list.length; i++){
            if(i%2==0){
                arr3.add(-4, list[i]);
            } else{
                arr3.add(list[i]);
            }
        }
        System.out.println(arr3.toString());
        
    }

}
