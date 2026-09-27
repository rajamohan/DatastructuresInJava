package com.rajamohan.patterns;


class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class FastAndSlowPointers {

    static Node head = null;
    static Node tail = null;

    static void addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    static void main(String[] args){

        addNode(2);
        addNode(4);
        addNode(6);
        Node middleNode = null; // we'll grab node "7" here
        addNode(7);
        middleNode = tail; // tail is currently the node with value 7
        addNode(9);
        addNode(5);
        addNode(8);

        // Create a cycle back to the middle node instead of head
        tail.next = middleNode;

        Node fast = head;
        Node slow = head;
        boolean cycleFound = false;

        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleFound = true;
                break;
            }
        }

        System.out.println(cycleFound ? "Cycle found..." : "Cycle not found...");
    }

}
