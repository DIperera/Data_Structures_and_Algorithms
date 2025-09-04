package pkg1;

import java.util.Scanner;

class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;
    private char[] arr;

    // Constructor
    public CircularQueue(int size) {
        maxSize = size;
        arr = new char[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Insert (enqueue)
    public void enqueue(char data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1; // wrap around
        }
        arr[++rear] = data;
        nItems++;
    }

    // Remove (dequeue)
    public char dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return '\0';
        }
        char temp = arr[front++];
        if (front == maxSize) {
            front = 0; // wrap around
        }
        nItems--;
        return temp;
    }

    // Peek (front element)
    public char peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return '\0';
        }
        return arr[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Check if full
    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int count = 0;
        int i = front;
        while (count < nItems) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % maxSize; // circular move
            count++;
        }
        System.out.println();
    }
}

public class CircularQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue('A');
        cq.enqueue('B');
        cq.enqueue('C');
        cq.enqueue('D');
        cq.enqueue('E');

        cq.display();

        System.out.println("Removed: " + cq.dequeue());
        System.out.println("Removed: " + cq.dequeue());

        cq.display();

        cq.enqueue('F');
        cq.enqueue('G');

        cq.display();

        System.out.println("Front element: " + cq.peek());
    }
}
/*
Output : 

Queue elements: A B C D E 
Removed: A
Removed: B
Queue elements: C D E 
Queue elements: C D E F G 
Front element: C

*/ 