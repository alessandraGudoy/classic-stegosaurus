package edu.ics211.h12;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args){
        UHM_Hashtable<String, Integer> hashtable = new UHM_Hashtable<>(1, 0.5);

        hashtable.put("o", 24);
        hashtable.put("null", null);
        hashtable.put("yo", 12);
        hashtable.put("y1", 3);


        System.out.println(hashtable.size());

        hashtable.p();

        System.out.println();


    }
}
