package edu.ics211.h08;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ICS211ArrayListIterator
 *  External iterator for an ArrayList<E>
 * 
 * @author Alessandra Gudoy
 */

public class ICS211ArrayListIterator<E> implements Iterator<E>{

    public E[] data;
    public int position;

    public ICS211ArrayListIterator(){ }

    public ICS211ArrayListIterator(ArrayList<E> data){
        this.data = (E[]) data.toArray();
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < data.length;
    }

    @Override
    public E next() {
        return this.data[position++];
    }

    public static void main(String[] args){
        ArrayList<String> arrList = new ArrayList<String>();
        
        arrList.add("awit");
        arrList.add("bahay");
        arrList.add("kamay");
        arrList.add("dalampasigan");
        p(arrList);

        ICS211ArrayListIterator<String> iterator = new ICS211ArrayListIterator<String>(arrList);
        ICS211ArrayListIterator<String> iterator2 = new ICS211ArrayListIterator<String>(arrList);
        
        for(int i=0; i<= arrList.size(); i++){
            try{
                p(iterator.hasNext());
                p(iterator.next());
            } catch(Exception e){
                p("Is it working?");
            }
        }

        p(iterator2.next());
        p(iterator2.hasNext());
        p(arrList);

    }

    public static <E> void p(E print){
        System.out.println("\n" + print);
    }
    
}
