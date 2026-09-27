package com.rajamohan.patterns;

public class GapCreation {
    static Node head = null;
    static Node tail = null;

    static  void addNode(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    static void addNodes(){
        addNode(2);
        addNode(4);
        addNode(6);
        addNode(7);
        addNode(9);
        addNode(5);
        addNode(8);
    }

    static Node findNthFromEnd(int n){
        Node fast = head;
        Node slow = head;

        // Step 1: create the gap — move fast n steps ahead
        for(int i=0; i<n; i++){
            if(fast == null){
                // list is shorter than n
                return null;
            }
            fast = fast.next;
        }

        // Step 2: move both together until fast hits the end
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    static Node deleteNthFromEnd(Node head, int n){
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast= dummy;
        Node slow=dummy;

        // Step 1: move fast n+1 steps ahead (so slow lands one BEFORE the target)
        for(int i=0; i<=n; i++){
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }

        // Step 2: move both together until fast hits the end
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        // slow is now right before the node to delete
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String args[]){
        addNodes();
        int n= 3;

        Node result = findNthFromEnd(n);
        System.out.println(n+" node from end: " + (result != null ? result.data : "not found"));

        Node curr = head;

        System.out.println("Before deleting nth element");
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        head = deleteNthFromEnd(head, n);
        System.out.println("After deleting nth element");

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");

    }
}
