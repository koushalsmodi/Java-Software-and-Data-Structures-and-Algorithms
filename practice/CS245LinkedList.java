class Node{
    String data;
    Node next;

    Node (String newData){
        this.data = newData;
        this.next = null;
    }

    public void setData(String newData){
        this.data = newData;
    }

    public String getData(){
        return this.data;
    }
}

public class CS245LinkedList{
    private Node head;

    public void add(String newData){
        Node newNode = new Node(newData);
        if (head == null){
            head = newNode;
        } 
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }


    public static void main(String[] args) {
        CS245LinkedList list1 = new CS245LinkedList();
        list1.add("Ganpati");
        list1.add("Hanuman");
        list1.add("Modeshwari Maa");
        list1.printList();


        
    }
}