//  remove first
class Node {
    String name;
    Node next;

    Node(String newName) {
        this.name = newName;
        this.next = null;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}

public class SingleLinkedList {
    private Node head;
    private int size = 0;

    public void add(String newName) {
        Node newNode = new Node(newName);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;

        }

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getName());
            current = current.next;
        }
    }

    public void size() {
        System.out.println("Number of elements: " + size);
    }

    public void insertData(String nodeData, String newData) {
        Node newNode = new Node(newData);
        if (head == null){
            head = newNode;
            size++;
            return;
        }
        else{
            Node current = head;
            while (current.getName() != newData && current.next!=null){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteData(String data){
    
        if (head == null){
            System.out.println("No elements in the linkedlist");
        }
        if (head.getName() == data){
            head = head.next;
            size--;
            return;
        }

        else{
            Node current = head;
            Node prev = null;
            while (current.getName() != data){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            size--;
        }
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        } else{
            return false;
        }
    }

    public void first(){
        if (head == null){
            System.out.println("No elements to return");
        }
        else{
            System.out.println(head.getName());
        }
    }

    public void last(){
        if (head == null){
            System.out.println("No elements");
        }

        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            System.out.println(current.getName());
        }
    }

    public void addFirst(String s){
        Node newNode = new Node(s);
        if (head == null){
            head = newNode;
            size++;
            return;
        }
        else{
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addLast(String s){
        Node newNode = new Node(s);
        if (head == null){
            head = newNode;
            size++;
            return;
        }

        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    public void removeFirst(){
        if (head == null){
            System.out.println("no elements to remove");
        }
        else{
            head = head.next;
            size--;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList sl = new SingleLinkedList();
        sl.add("SFO");
        sl.add("LAS");
        sl.insertData("LAS", "BOM");
        sl.add("SJC");
        sl.add("DXB");
        sl.deleteData("BOM");
        sl.printList();
        sl.size();
        System.out.println(sl.isEmpty());
        sl.first();
        sl.last();
        System.out.println();
        sl.addFirst("Ganesh");
        sl.addFirst("bread");
        sl.printList();
        System.out.println();
        sl.addLast("Hanuman");
        sl.printList();
        System.out.println();
        sl.removeFirst();
        sl.printList();

    }
}