class Stack{
    int a[] = new int[5];
    int top = -1;

    public void push(int data){

        if(top == a.length -1){
            System.out.println("Stack is full..");
        } else{
            top++;
            a[top] = data;
        }

    }

    public void pop(){

        if(top == -1){
            System.out.println("Stack is empty..");
        } else {
            System.out.println("Poped element...." + a[top]);
            top--;
        }
    }

    public void peek(){
        if(top == -1){
            System.out.println("Stack is empty..");
        } else {
            System.out.println("Peek element : " + a[top]);
        }

    }

    public void display(){
        for(int i=top; i>=0; i--){
            System.out.println(a[i]);
        }
    }

}


public class StackStructure {
    public  static  void main(String args[]){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();
        stack.peek();
        stack.pop();

        stack.display();

        stack.push(50);
        stack.peek();
        stack.push(60);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
    }
}
