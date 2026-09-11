class CircularQueue{
    int a[] = new int[5];
    int front = -1;
    int rear = -1;

    public void enqueue(int data){
        // The modulo check is used to identify correct rear position this is the actual gist of finding the correct position
        if(front == (rear+1) % a.length) {
            System.out.println("Queue is full...");
        } else if( front == -1 && rear == -1){
            rear = 0;
            front = 0;
            a[rear] = data;
        } else {
            // The modulo check is used to identify correct rear position this is the actual gist of finding the correct position
            rear = (rear+1) % a.length;
            a[rear] = data;
        }
    }

    public void display(){
        if(rear == -1 && front == -1){
            System.out.println("Queue is empty....");
        } else {
            int i = front;
            while(i!= rear){
                System.out.println(a[i]);
                // The modulo check is used to identify the correct position this is the actual gist of finding the correct position
                i = (i+1) % a.length;
            }
            System.out.println(a[rear]);
        }
    }
    
    public void dequeue(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty....");
        } else if ( front == rear) {
            System.out.println("Dequeued element ... " + a[front]);
            rear = -1;
            front = -1;
        } else{
            System.out.println("Dequeued element ... " + a[front]);
            // The modulo check is used to identify the correct front position this is the actual gist of point for next check
            front = (front+1) % a.length; // This is similiar to railway time check (ie) 13 means 1 pm, how? 13%12 remainder 1
        }
    }

    public void peek(){
        System.out.println("Peek element ... " + a[front]);
    }
}

public class CircularQueueByArray {
    public static void main(String[] args){
        CircularQueue queue = new CircularQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();
        queue.dequeue();
        queue.enqueue(60);
        queue.display();
    }
}
