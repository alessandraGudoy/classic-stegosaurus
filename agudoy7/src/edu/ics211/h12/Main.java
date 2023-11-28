package edu.ics211.h12;

public class Main {
    public static void main(String[] args){
        // System.out.println(test0());
        // System.out.println();
        System.out.println(test1());
        // System.out.println();
        // System.out.println(test2());
        // System.out.println();
        // System.out.println(test7());


    }

    public static boolean test0(){
        UHM_Hashtable<String, String> hash = new UHM_Hashtable<>();

        // size is 0
        if(hash.size() != 0){ return false; }
        System.out.print("*1");

        // add foo=bar
        hash.put("foo", "bar");
        if(hash.size() != 1){ return false; }
        System.out.print("*2");

        // replace previous value of foo to bar2 (foo=bar2)
        hash.put("foo", "bar2");
        if(hash.size() != 1){ return false; }
        System.out.print("*3");

        // check if value of foo is replaced
        if(!hash.get("foo").equals("bar2")){ return false; }
        System.out.print("*4");

        return true;
    }

    public static boolean test1(){
        UHM_Hashtable<String, String> hash = new UHM_Hashtable<>(20, 0.75);

        // check if array length is 20
        if(hash.arrayLen() != 20){ return false; }
        System.out.print("*1");

        // check if current load factor is 0
        if(hash.loadFactor() != 0){ return false; }
        System.out.print("*2");

        // add foo=bar2 and do not rehash
        hash.put("foo", "bar2");
        if(hash.arrayLen() != 20){ return false; }
        System.out.print("*3");

        // check if current load factor is 0.05
        if(hash.loadFactor() != 0.05){ return false; }
        System.out.print("*4");

        // check if the maximum length of any list is 1
        if(hash.maxListLen() != 1){ return false; }
        System.out.print("*5");

        return true;
    }

    public static boolean test2(){
        return true;
    }

    public static boolean test7(){
        return true;
    }
}
