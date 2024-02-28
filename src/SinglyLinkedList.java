/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/24
Description: Creating and implementing an iterator design pattern to a Linked List
 */


public class SinglyLinkedList<T> implements LinkedIterator<T> {
    Node head;
    int size;

    SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    // Inserts at the beginning of the linked list
    public void add(Node newNode){
        if(newNode != null) {
            // 1- Set next of newNode  to be the head
            newNode.next = this.head;
            // 2- Adjust the head node to be the newNode
            this.head = newNode;
            // 3- Increment linked list size
            this.size++;
        } else {
            System.out.println("Can't add the new node, it's null");
        }
    }

    public void insertAfter(Node prevNode, Node newNode){
        if(prevNode == null){
            System.out.println("Previous node does not exist");
            return;
        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    // Append a new node to the linked list
    public void append(Node newNode){
        // if the list is empty then we're adding the head node
        if(head == null){
            add(newNode);
            return;
        }
        newNode.next = null;
        // Traverse the list from the beginning (head) till the end (the node with next = n)
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        // Now we can newNode to the last node
        last.next = newNode;
        size++;
    }

    // Removes the last node in the linked list
    public void remove(){
        if(head == null)
            return;
        if(head.next == null)
            head = null;  // we only have the head node
        else { // we have more than one node in the list
            Node previous = head;
            Node last = head.next;
            while (last.next != null){
                previous = previous.next;
                last = last.next;
            }
            previous.next = null;
        }
        size--;
    }

    //Overloaded function remove
    public void  remove(int index){  //early binding

    }
    // using the linked iterator interface
    public T getNext(){
        if (! hasNext()){
            return null;
        }
        Node currentNode = head;

        T data = (T) currentNode.data;
        currentNode = currentNode.next;
        return data;
    }

    public boolean hasNext(){
        return head != null;
    }

    public void reset(){
        clear();
    }

    public void clear(){
          this.head = null;
          size = 0;
    }


    // reverse Linked list function
    public void reverse(){
        Node previous = null;
        Node next;

        while (head != null ){
            next = head.next; // Node next is pointing to the node after the head
            head.next = previous; //Head.next node will point to the previous Node
            previous = head; // previous node will become the head
            head = next; // head will point to next
        }
        head = previous; // head will point back to previous
    }

    //Prints the objects of a linkedlist
    public void printList(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node it = head;
        while (it != null){
            System.out.println(it.data + " ");
            it = it.next;
        }
    }

    public boolean isCyclic(){
        Node slow = this.head;
        Node fast = this.head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

}
