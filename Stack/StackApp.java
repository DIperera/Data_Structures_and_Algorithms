package pkg1;

public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);  // create a stack with max size 10

        theStack.push(30);  // insert given items
        theStack.push(80);
        theStack.push(100);
        theStack.push(25);

        while( !theStack.isEmpty() ) {  // until it is empty, delete item from stack
            System.out.println(theStack.pop());
        }
    }
}