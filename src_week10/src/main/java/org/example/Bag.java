package org.example;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>{
    private Node <T> first; // Beginning  of the bag
    private int n; //Number of elements in the bag

    public Bag(){
        first = null;
        n = 0;
    }

    //copy constructor
    public Bag(Bag<T> b){
        this.first = b.first;
        this.n = b.n;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void add(T item){
        Node<T> oldFirst = first;
        first = new Node(item, oldFirst);
        n++;
    }

    public Iterator<T> iterator(){
        return new BagIterator(first);
    }

    // An Iterator helper class
    private class BagIterator implements Iterator<T>{
        private Node<T> current;

        public  BagIterator(Node<T> first){
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }

        @Override
        public T next() {

            if(!hasNext()){
                return null;
            }

            T item = current.data;
            current = current.next;
            return item;
        }

    }

    // Just of test Purposes - Main method to test the Bag OS
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("Hello World");
        bag.add(" Hi there");
        bag.add(" Hola");

        System.out.println("Size of bag = " + bag.size());

        Iterator it = bag.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for (String s : bag){
            System.out.println(s);
        }
    }
}
