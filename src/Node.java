/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/24
Description: Creating and implementing an iterator design pattern to a Linked List
*/
public class Node<T> {
    T data;
    Node next;
    //Node prev

    Node(T data){
        this.data = data;
        this.next = null;
    }

    Node(T data, Node nextNode){
        this.data = data;
        this.next = nextNode;

    }
}
