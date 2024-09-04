class Node{
    int data;
    Node next;
    
    Node(int newData){
        this.data = newData;
    }

    public void setData(int newData){
        this.data = newData;
    }

    public int getData(){
        return this.data;
    }
}

public class CircularlyLinkedList{

    private Node tail;
    private int size=  0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void first(){
        if (tail==null){
            System.out.println("no elements in the circularly linked list");
        }
        else{
            System.out.println(tail.next.getData());
        }
    }

    public void last(){
        if (tail==null){
            System.out.println("no elements to return");
        }
        else{
            System.out.println(tail.getData());
        }

    }

    public void rotate(){
        tail = tail.next;
    }

    public void addFirst(int e){
        Node newNode = new Node(e);

        if (tail==null){
            newNode.next = newNode;
            tail = newNode;
        }
        else{
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void addLast(int e){
        addFirst(e);
        tail = tail.next;
    }

    public void removeFirst(){
        if (tail==null){
            System.out.println("nothing in the list");
        }
        else{
            tail.next = tail.next.next;
        }

    }
    public static void main(String[] args) {

        CircularlyLinkedList cll = new CircularlyLinkedList();
        cll.addFirst(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.first();
        cll.last();
        cll.rotate();
        cll.first();
        cll.removeFirst();
        cll.first();

        
    }
}






















// class Node {
//     int data;
//     Node next;

//     Node(int newData) {
//         this.data = newData;
//         this.next = null;
//     }

//     public void setData(int newData) {
//         this.data = newData;
//     }

//     public int getData() {
//         return this.data;
//     }
// }

// public class CircularlyLinkedList {

//     private Node tail;
//     private int size = 0;

//     public CircularlyLinkedList() {
//         tail = null;
//     }

//     public int size() {
//         return size;
//     }

//     public boolean isEmpty() {
//         return size == 0;
//     }

//     // Return the first element
//     public void first() {
//         if (isEmpty()) {
//             System.out.println("No elements");
//         } else {
//             System.out.println(tail.next.getData());
//         }
//     }

//     // Return the last element
//     public void last() {
//         if (isEmpty()) {
//             System.out.println("No elements");
//         } else {
//             System.out.println(tail.getData());
//         }
//     }

//     // Rotate the tail to the next node
//     public void rotate() {
//         if (!isEmpty()) {
//             tail = tail.next;
//         }
//     }

//     // Add a new node at the beginning
//     public void addFirst(int e) {
//         Node newNode = new Node(e);
//         if (isEmpty()) {
//             newNode.next = newNode; // Circular reference
//             tail = newNode;
//         } else {
//             newNode.next = tail.next;
//             tail.next = newNode;
//         }
//         size++;
//     }

//     // Add a new node at the end
//     public void addLast(int e) {
//         addFirst(e); // Adding at the end is similar to adding at the start in a circular list
//         tail = tail.next; // Update tail to the new node
//     }

//     // Remove the first node
//     public void removeFirst() {
//         if (isEmpty()) {
//             System.out.println("No elements to remove");
//         } else {
//             if (size == 1) {
//                 tail = null; // List is empty now
//             } else {
//                 tail.next = tail.next.next; // Skip the first node
//             }
//             size--;
//         }
//     }

//     public static void main(String[] args) {
//         CircularlyLinkedList cl = new CircularlyLinkedList();
//         cl.addFirst(1);
//         cl.addLast(2);
//         cl.addLast(3);
//         cl.first(); // Should print 1
//         cl.last();  // Should print 3
//         cl.rotate();
//         cl.first(); // Should print 2 after rotation
//         cl.removeFirst();
//         cl.first(); // Should print 3 after removing 2
//     }
// }
