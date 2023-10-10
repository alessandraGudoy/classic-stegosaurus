package edu.ics211.h07;

public interface SortedLinkedListInterface<E extends Comparable<E> > {

    int size();

    E get(int index);

    boolean add(E value);

    boolean remove(E value);

    int indexOf(E value);

    String toString();
    
}
