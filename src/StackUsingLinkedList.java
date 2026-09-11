class StackNode {
    int data;
    StackNode next;
    public StackNode(int data) {
        this.data = data;
    }
}

class MyStack{

    StackNode top;

    public void push(int data){
        StackNode sn = new StackNode(data);
        if(top == null){ // First element
            top = sn;
        } else{ // Subsequent elements
            sn.next = top;
            top = sn;
        }
    }

    public void display(){
        StackNode temp = top;
        while(temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void peek(){
        if(top == null){
            System.out.println("Stock is empty");
        } else{
            System.out.println("Peeked element :" + top.data);
        }
    }

    public void pop(){
        StackNode temp = top;
        if(temp == null){
            System.out.println("Stack is empty..");
        } else{
            System.out.println("Poped element.." + temp.data);
            top = temp.next;
            temp.next = null;
        }
    }

}
public class StackUsingLinkedList {

    public static void main(String args[]){
         MyStack stack = new MyStack();
         stack.push(10);
         stack.push(20);
         stack.push(30);
         stack.push(40);

         stack.display();

         stack.peek();
         stack.pop();

        stack.peek();
        stack.pop();

        stack.peek();
        stack.pop();

        stack.pop();
        stack.pop();
        stack.pop();
    }
}
