package com.rajamohan.base;

class QueueNode{ // This is the actual class which will create queue DS
    int data;
    QueueNode next;
    public QueueNode(int data) {
        this.data = data;
    }
}

class MyLinkedListQueue{
    QueueNode front;
    QueueNode rear;

    public void enqueue(int data){ // Adding element to the queue
        QueueNode node = new QueueNode(data);
        if(rear == null){ // Very first element
            front = node;
            rear = node;
        }
        else{ // Sub sequent elements
            rear.next = node; // Updating newly created node as rear in prev / very first element ref
            rear = node; // Updating newly created node as rear node.
        }
    }

    public void dequeue(){ // Removing element from queue
        if(rear == null){ // To avoid under flow error (Null pointer exception)
            System.out.println("Queue is empty...");
        } else if(front == rear){ // If only one element is there queue it will dequeue and reset the queue as zero
            System.out.println("Dequeued element = " + front.data);
            front = null; rear = null;
        } else { // Dequeue is always take the 1st (front) element from queue.
            System.out.println("Dequeued element = " + front.data);
            front = front.next; // After removing first element next element will be point as fron if queue has multiple nodes
        }
    }

    public void peek(){
        if(front == null){
            System.out.println("Queue is empty...");
        } else{
            System.out.println("Peek element = " + front.data);
        }
    }

    public void display(){
        if(rear == null){
            System.out.println("Queue is empty...");
        } else{
            QueueNode temp = front; // For display copy of obj will create to avoid refence issue
            while(temp.next!=null){ // Will check is the pointer moved to rear node, if its reach last will exit the loop
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
}

public class QueueUsingLinkedList {
    public static void main(String args[]){
        MyLinkedListQueue myLinkedListQueue = new MyLinkedListQueue();
        myLinkedListQueue.enqueue( 10);
        myLinkedListQueue.enqueue( 20);
        myLinkedListQueue.enqueue( 30);
        myLinkedListQueue.enqueue( 40);
        myLinkedListQueue.enqueue( 50);

        myLinkedListQueue.display();

        myLinkedListQueue.dequeue();
        myLinkedListQueue.peek();
        myLinkedListQueue.dequeue();
        myLinkedListQueue.peek();
        myLinkedListQueue.dequeue();
        myLinkedListQueue.peek();
        myLinkedListQueue.dequeue();
        myLinkedListQueue.peek();
        myLinkedListQueue.dequeue();
        myLinkedListQueue.peek();

        myLinkedListQueue.enqueue(60);
        myLinkedListQueue.peek();
    }
}
