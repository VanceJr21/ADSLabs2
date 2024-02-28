/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/24
Description: Creating and implementing an iterator design pattern to a Linked List
 */

public interface LinkedIterator<T> {

    public boolean hasNext();

    T getNext();

    public void reset();
}
