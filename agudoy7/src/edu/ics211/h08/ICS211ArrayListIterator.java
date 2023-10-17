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
        return position < this.data.length;
    }

    @Override
    public E next() {
        return this.data[position++];
    }

    @Override
    public void remove() {
        
    }
    
}
