class Node{
    int data;
    StackNode next;
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList{
    StackNode head, tail;
    public void insert(int data){
        StackNode node = new StackNode(data); // Creating new node
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

        if(head == null){
            System.out.println("List empty");
        }
        else {
            StackNode temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public void inserAtBegining(int data){
        StackNode node = new StackNode(data);
        node.next = head;
        head = node;
    }

    public void insertAt(int position, int data){
        StackNode node = new StackNode(data);
        StackNode temp = head;
        for(int i=0; i<position-1; i++){
            temp = temp.next; // First getting the position -1 node for update ref
        }
        node.next = temp.next; // set newly created node as prev node to position +1 node
        temp.next = node; // set newly created node as next node to position -1 node
    }

    public void deleteAt(int position){
        if(position == 0){
          System.out.println("Delete at begining");
          StackNode temp = head; // Getting head
          head = head.next; // Setting head as next element of head so it will delete 1st entry
          temp.next = null;
        }
        else if(position == -1){
            System.out.println("Delete at end");
            StackNode temp = head;
            while (temp.next!=tail){ // Iterate until pointer reaches previous node of tail node
                temp = temp.next; // get the last before node
            }
            temp.next  = null;  // Remove next ref in 2nd last node
            tail = temp; // set 2nd last node as tail
        } else{
            System.out.println("Deleted at position : " + position);
            StackNode temp = head;
            for(int i=0; i<position-1; i++){
                temp = temp.next; // Reaches the previous node of position node
            }
            temp.next = temp.next.next; // Getting the next ref of position node and setting to position -1 nodes ref

        }
    }
}

public class SingleLinkedList {
    public  static  void  main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.insert(60);

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
        IO.println("-------------------------------------");
        linkedList.deleteAt(0);
        linkedList.display();
        IO.println("-------------------------------------");
        linkedList.deleteAt(-1);
        linkedList.display();
        IO.println("-------------------------------------");
        linkedList.deleteAt(3);
        linkedList.display();
    }
}
