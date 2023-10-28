package edu.ics211.h08;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    private static final String[] list = {"ah", "ba", "ka", "da", "eh", "ga"};

    public static void main(String[] args){
        //arrList();
        linked();

    }

    public static <E> void linked(){
        ICS211LinkedList<String> linkedList = new ICS211LinkedList<String>();

        for(String str : list){
            linkedList.add(str);
        }

        // adding at front
        linkedList.add(0,"NEW HEAD");
        // adding at end
        linkedList.add(7,"NEW TAIL");

        
        p(linkedList.remove(7));
        p(linkedList.remove(6));
        p(linkedList.remove(4));
        p(linkedList.remove(2));
        p(linkedList.remove(0));

        p(linkedList.getHead());
        p(linkedList.getTail());

        p(linkedList.toString());

        Iterator<String> it = linkedList.iterator();
        Iterator<String> it2 = linkedList.iterator();
        p(it.hasNext());
        p(it.next());
        p(it.next());

        p(it2.next());
        it.remove();

        p(linkedList.toString());
        

    }

    public static void arrList(){
        ArrayList<String> arrList = new ArrayList<String>();
        
        for(String str : list){
            arrList.add(str);
        }

        p(arrList.toString());

    }

    public static <E> void p(E print){
        System.out.println("" + print);
    }
}
