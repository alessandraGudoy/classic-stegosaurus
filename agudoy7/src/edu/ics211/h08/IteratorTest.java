package edu.ics211.h08;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args){
        //arrList();
        linked();

    }

    public static <E> void linked(){
        ICS211LinkedList<String> linkedList = new ICS211LinkedList<String>();

        linkedList.add("def");
        linkedList.add("jkl");
        linkedList.add(0,"abc");
        linkedList.add(2,"ghi");
        linkedList.add(4,"mno");

        int index = 0;
        for(String str : linkedList){
            p(str);
            linkedList.remove(index);
            p(linkedList.toString());
        }

        Iterator<String> iterator = linkedList.iterator();
        
        // for(int i=0; i <= linkedList.size; i++){
        //     try{
        //         p(iterator.hasNext());
        //         p(iterator.next());
        //     } catch(Exception e){
        //         p(e);
        //         p("Is it working?");
        //     }
        // }

    }

    public static void arrList(){
        ArrayList<String> arrList = new ArrayList<String>();
        
        arrList.add("awit");
        arrList.add("bahay");
        arrList.add("kamay");
        arrList.add("dalampasigan");
        p(arrList);

        ICS211ArrayListIterator<String> iterator = new ICS211ArrayListIterator<String>(arrList);
        ICS211ArrayListIterator<String> iterator2 = new ICS211ArrayListIterator<String>(arrList);
        
        for(int i=0; i <= arrList.size(); i++){
            try{
                p(iterator.hasNext());
                p(iterator.next());
            } catch(Exception e){
                p(e);
                p("Is it working?");
            }
        }

        p(iterator2.next());
        p(iterator2.hasNext());
        p(arrList);
    }

    public static <E> void p(E print){
        System.out.println("" + print);
    }
}
