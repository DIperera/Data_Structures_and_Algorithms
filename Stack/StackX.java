package pkg1;

public class StackX {
	private int maxSize;    // size of stack array
    private double[] stackArray;   //array without size
    private int top;        // top value of the stack

    public StackX(int s) { // initialize the stack
        maxSize = s;       // set array size
        stackArray = new double[maxSize];
        top = -1;          // no items
    }

    public void push(double j) {
        // check whether stack is full
        if (top == maxSize - 1)
            System.out.println("Stack is full");
        else
            stackArray[++top] = j; //increment happens before assignment. top 0 -> 1 -> 2 -> 3 -> ... -> 9  
    }

    public double pop() {
        if (top == -1)
            return -99;
        else
            return stackArray[top--]; //return value and then decrement
    }

    public double peek() {
        if (top == -1)
            return -99;
        else
            return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

}
