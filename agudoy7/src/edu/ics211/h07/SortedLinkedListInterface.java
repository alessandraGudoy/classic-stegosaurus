package edu.ics211.h07;

/*
 * SortedLinkedListInterface
 * @author Edo Biagioni
 */
public interface SortedLinkedListInterface<E extends Comparable<E> > {

    int size();

    E get(int index);

    boolean add(E value);

    boolean remove(E value);

    int indexOf(E value);

    String toString();
    
}
