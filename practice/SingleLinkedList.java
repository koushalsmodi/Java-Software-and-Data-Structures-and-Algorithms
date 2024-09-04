class Node{
    int data;
    Node next;

    Node(int newData){
        this.data = newData;
        this.next = null;
    }

    public void setData(int newData){
        this.data = newData;
    }

    public int getData(){
        return this.data;
    }

}

public class SingleLinkedList{
    private Node head;
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int newData){
        Node newNode = new Node(newData);

        if (head==null){
            head = newNode;
            return;
        }

        else{
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    public void printList(){
        Node current = head;
        while (current !=null){
            System.out.println(current.getData());
            current = current.next;
            
        }

    }

    public void insertData(int nodeData, int newData){
        Node newNode = new Node(newData);
        if (head==null){
            head = newNode;
            return;
        }
        else{
            Node current = head;
            while (current.next != null && current.getData() != nodeData){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            
        }
        size++;
    }

    public void deleteData(int nodeData){
        Node prev = null;
        if (head.getData() == nodeData){
            head = head.next;
        }
        else{
            Node current= head;
            while (current.getData() != nodeData && current != null){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            
        }
        size--;
    }

    public void first(){
        if (head==null){
            System.out.println("no elements to return");
        }
        else{
            System.out.println(head.getData());
        }
    }

    public void last(){
        if (head==null){
            System.out.println("empty linked list");
        }
        else{
            Node current = head;
            while (current.next !=null){
                current = current.next;
            }
            System.out.println(current.getData());
        }
    }

    public void addFirst(int e){
        Node newNode = new Node(e);
        if (head==null){
            head=newNode;
            return;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addlast(int e){
        Node newNode = new Node(e);
        if (head ==null){
            head = newNode;
            return;
        }
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeFirst(){
        if (head==null){
            System.out.println("no elements to remove");
        }
        else{
            head = head.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList ssl = new SingleLinkedList();
        ssl.addFirst(1);
        ssl.addlast(2);
        ssl.addlast(4);
        ssl.insertData(2,3);
        ssl.deleteData(3);
        ssl.printList();
        System.out.println();
        ssl.first();
        ssl.last();
        System.out.println();
        System.out.println();
        ssl.addFirst(0);
        ssl.addlast(10);
        ssl.printList();
        System.out.println();
        System.out.println();
        ssl.removeFirst();
        ssl.printList();

        // System.out.println(ssl.size());
        
    }
}



















// class Node {
//     String name;
//     Node next;

//     Node(String newName) {
//         this.name = newName;
//         this.next = null;
//     }

//     public void setName(String newName) {
//         this.name = newName;
//     }

//     public String getName() {
//         return this.name;
//     }
// }

// public class SingleLinkedList {
//     private Node head;
//     private int size = 0;

//     public void add(String newName) {
//         Node newNode = new Node(newName);
//         if (head == null) {
//             head = newNode;
//             size++;
//             return;
//         }

//         else {
//             Node current = head;
//             while (current.next != null) {
//                 current = current.next;
//             }
//             current.next = newNode;
//             size++;

//         }

//     }

//     public void printList() {
//         Node current = head;
//         while (current != null) {
//             System.out.println(current.getName());
//             current = current.next;
//         }
//     }

//     public void size() {
//         System.out.println("Number of elements: " + size);
//     }

//     public void insertData(String nodeData, String newData) {
//         Node newNode = new Node(newData);
//         if (head == null){
//             head = newNode;
//             size++;
//             return;
//         }
//         else{
//             Node current = head;
//             while (current.getName() != newData && current.next!=null){
//                 current = current.next;
//             }
//             newNode.next = current.next;
//             current.next = newNode;
//             size++;
//         }
//     }

//     public void deleteData(String data){
    
//         if (head == null){
//             System.out.println("No elements in the linkedlist");
//         }
//         if (head.getName() == data){
//             head = head.next;
//             size--;
//             return;
//         }

//         else{
//             Node current = head;
//             Node prev = null;
//             while (current.getName() != data){
//                 prev = current;
//                 current = current.next;
//             }
//             prev.next = current.next;
//             size--;
//         }
//     }

//     public boolean isEmpty(){
//         if (head == null){
//             return true;
//         } else{
//             return false;
//         }
//     }

//     public void first(){
//         if (head == null){
//             System.out.println("No elements to return");
//         }
//         else{
//             System.out.println(head.getName());
//         }
//     }

//     public void last(){
//         if (head == null){
//             System.out.println("No elements");
//         }

//         else{
//             Node current = head;
//             while (current.next != null){
//                 current = current.next;
//             }
//             System.out.println(current.getName());
//         }
//     }

//     public void addFirst(String s){
//         Node newNode = new Node(s);
//         if (head == null){
//             head = newNode;
//             size++;
//             return;
//         }
//         else{
//             newNode.next = head;
//             head = newNode;
//             size++;
//         }
//     }

//     public void addLast(String s){
//         Node newNode = new Node(s);
//         if (head == null){
//             head = newNode;
//             size++;
//             return;
//         }

//         else{
//             Node current = head;
//             while (current.next != null){
//                 current = current.next;
//             }
//             current.next = newNode;
//             size++;
//         }
//     }

//     public void removeFirst(){
//         if (head == null){
//             System.out.println("no elements to remove");
//         }
//         else{
//             head = head.next;
//             size--;
//         }
//     }

//     public static void main(String[] args) {
//         SingleLinkedList sl = new SingleLinkedList();
//         sl.add("SFO");
//         sl.add("LAS");
//         sl.insertData("LAS", "BOM");
//         sl.add("SJC");
//         sl.add("DXB");
//         sl.deleteData("BOM");
//         sl.printList();
//         sl.size();
//         System.out.println(sl.isEmpty());
//         sl.first();
//         sl.last();
//         System.out.println();
//         sl.addFirst("Ganesh");
//         sl.addFirst("bread");
//         sl.printList();
//         System.out.println();
//         sl.addLast("Hanuman");
//         sl.printList();
//         System.out.println();
//         sl.removeFirst();
//         sl.printList();

//     }
// }