class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList{
    Node head, tail;
    public void insert(int data){
        Node node = new Node(data); // Creating new node
        node.next = null;
        if (head == null){ // For first node
            head = node;
            tail = node;
        } else{ // Second node
            tail.next = node; // First setting the tail as a newly created to previous node ref
            tail = node;
        }
    }

    public void display(){
        Node temp = head ;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void inserAtBegining(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAt(int position, int data){
        Node node = new Node(data);
        Node temp = head;
        for(int i=0; i<position-1; i++){
            temp = temp.next; // First getting the position -1 node for update ref
        }
        node.next = temp.next; // set newly created node as prev node to position +1 node
        temp.next = node; // set newly created node as next node to position -1 node
    }
}

public class SingleLinkedList {
    public  static  void  main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.display();
        IO.println("-------------------------------------");
        linkedList.inserAtBegining(7);
        linkedList.display();
        IO.println("-------------------------------------");
        linkedList.inserAtBegining(5);
        linkedList.display();
        IO.println("-------------------------------------");
        linkedList.insertAt(3, 15);
        linkedList.display();
    }
}
