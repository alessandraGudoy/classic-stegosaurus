package edu.ics211.h12;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        UHM_Hashtable<String, Integer> hashtable = new UHM_Hashtable<>();

        System.out.println(hashtable.size());
        hashtable.put("o", 3);
        hashtable.put("yo", 3);
        hashtable.put("y1", 3);
        System.out.println(hashtable.size());
        System.out.println(hashtable.maxListLen());

        hashtable.p();



    }
}
