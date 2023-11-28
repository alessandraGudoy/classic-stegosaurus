package edu.ics211.h12;

public class Main {
    public static void main(String[] args){
        // System.out.println(test0());
        // System.out.println();
        // System.out.println(test1());
        // System.out.println();
        // System.out.println(test2());
        // System.out.println();
        System.out.println(test7());


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
        UHM_Hashtable<String, String> hash = new UHM_Hashtable<>(8, 0.75);

        // put aah=val0 and aap=val1 into hash table
        // check if max list length was 2
        hash.put("aah", "val0");
        hash.put("aap", "val1");
        if(hash.maxListLen() != 2){ return false; }

        // check if size of hash table is 2
        if(hash.size() != 2){ return false; }

        // check if load factor is 0.25
        if(hash.loadFactor() != 0.25){ return false; }

        // clear hash
        hash.clear();

        // check if size of hash table is 0
        if(hash.size() != 0){return false; }

        // check if current load factor is 0
        if(hash.loadFactor() != 0){ return false; }


        return true;
    }

    public static boolean test7(){
        UHM_Hashtable<Integer, Integer> hash = new UHM_Hashtable<>(100, 100);

        for(int i=0; i<9999; ++i){
            hash.put(i, (int) Math.random());
        }

        if(hash.maxListLen() < 95){ return false; }

        return true;
    }

}
