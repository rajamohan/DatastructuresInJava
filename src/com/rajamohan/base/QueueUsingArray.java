package com.rajamohan.base;

class QueueByArray{
    int a[] = new int[5];
    int rear = -1;
    int front = -1;

    public void enqueue(int data){
        if(rear == a.length-1){
            System.out.println("Queue is full....");
        } else if (rear ==-1 && front == -1 ){ // Inserting First element
             front = 0;
             rear = 0;
             a[rear] = data;
        } else { // Inserting subsequent element
            rear++;
            a[rear] = data;
        }
    }

    public void display() {
        if( front == -1 && rear == -1 ){
            System.out.println("Queue is empty....");
        } else {
            for(int i=front; i<=rear; i++){
                System.out.println(a[i]);
            }
        }
    }

    public void dequeue(){
        if(front == -1 && rear == -1){ // Check is queue empty
            System.out.println("Queue is empty....");
        } else if (front == rear){ // If only one element it will pull and reset the front & rear
            System.out.println("Dequeue : " + a[front]);
            rear = -1;
            front = -1;
        } else{ // After dequeue the element need to inc the front ref
            System.out.println("Dequeue : " + a[front]);
            front++;
        }
    }

    public void peek(){
        System.out.println("peek element : " + a[front]);
    }
}

public class QueueUsingArray {

    public static void main (String[] args){
        QueueByArray queue = new QueueByArray();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();
        queue.dequeue();
        //  In normal array implementation even the front and rear pointer moved to correct position still
        //  the rear position points to last element so it will refrain to add the new element to array so we need to implement the circular queue
        queue.enqueue(60); //
        queue.display();
    }
}
