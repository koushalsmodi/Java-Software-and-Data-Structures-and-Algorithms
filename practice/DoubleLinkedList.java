class Node {

    int data;
    Node prevNode;
    Node nextNode;

    Node(int newData) {
        this.data = newData;
        this.prevNode = null;
        this.nextNode = null;
    }

    public void setData(int newData) {
        this.data = newData;
    }

    public int getData() {
        return this.data;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;

    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

}

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.nextNode = head;
            head.prevNode = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.nextNode;
            head.prevNode = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prevNode;
            tail.nextNode = null;
        }
        size--;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.printList(); // Output: 1 2 3

        dll.addFirst(0);
        dll.printList(); // Output: 0 1 2 3

        dll.removeFirst();
        dll.printList(); // Output: 1 2 3

        dll.removeLast();
        dll.printList(); // Output: 1 2
    }
}
