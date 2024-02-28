/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/24
Description: Creating and implementing an iterator design pattern to a Linked List
 */


public class LinkedIteratorDiver {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.append(new Node("Hi"));
        sl.append(new Node("how"));
        sl.append(new Node("are"));
        sl.append(new Node("you"));
        sl.append(new Node("today"));
        sl.append(new Node("!"));

        sl.hasNext();
        sl.getNext();

        sl.printList();


    }
}
