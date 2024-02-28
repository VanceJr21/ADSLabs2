public class TestLinkedCycle {

    public static void main(String[] args) {

        SinglyLinkedList sl = new SinglyLinkedList();
        Node n1 = new Node("Hello");

        sl.append(n1);

        Node n2 = new Node("Welcome");

        sl.append(n2);

        Node n3 = new Node("To Matthew's Class (:");

        sl.append( n3);

        sl.append(n2);

        System.out.println(sl.isCyclic());
    }
}
