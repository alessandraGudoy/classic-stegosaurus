package edu.ics211.h08;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    private static final String[] list = {"ah", "ba", "ka", "da", "eh", "ga"};

    public static void main(String[] args){
        arrList();
        //linked();

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

        
        // p(linkedList.remove(7));
        // p(linkedList.remove(6));
        // p(linkedList.remove(4));
        // p(linkedList.remove(2));
        // p(linkedList.remove(0));

        

        p(linkedList.toString());

        p("");
        p("* * * ITERATOR TESTING * * *");
        p("");
        Iterator<String> it = linkedList.iterator();
        Iterator<String> it2 = linkedList.iterator();

        p(it2.next());
        p(it2.next());

        while(it2.hasNext()){
            p(it2.next());
            it.next();
            it.remove();
            p(linkedList.toString());
        }

        // p(it.hasNext());        // true
        // p(it.next());           // ah
        // p(it.next());           // ka
        // it.remove();
        // p(it.next());           // eh
        // it.remove();

        // System.out.print("HEAD: ");
        // p(linkedList.getHead());
        // System.out.print("TAIL: ");
        // p(linkedList.getTail());

        // p(linkedList.toString());   // ah -> eh

        // p(it2.next());
    }

    public static void arrList(){
        ArrayList<String> arrList = new ArrayList<String>();
        
        for(String str : list){
            arrList.add(str);
        }

        p(arrList.toString());

        ICS211ArrayListIterator<String> it = new ICS211ArrayListIterator<String>(arrList);

        for(int i=0; i<6; i++){
            p(it.next());
        }

        arrList.add("ha");
        p(it.next());

    }

    public static <E> void p(E print){
        System.out.println("" + print);
    }
}
