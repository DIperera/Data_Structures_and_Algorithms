//Write a Java program to demonstrate the use of Stack and Circular Queue together.
//Input - ABCD
//Output - ABCDDCBA

package labtest1;

import java.util.Scanner;

class Stack2 {
	
	private int maxsize;
	private Character[] arr;
	private int top;
	
	public Stack2(int max) {
		maxsize = max;
		arr = new Character[maxsize];
		top = -1;
	}
	public void insert(char j) {
		if(isFull()) {
			System.out.println("Full");
		}else {
			arr[++top] = j;
		}
	}
	public char pop() { //*
	    if (isEmpty()) {
	        System.out.println("Empty");
	        return '\0'; // default char when empty
	    }
	    return arr[top--];
	}
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if(top == maxsize - 1) {
			return true;
		}
		return false;
	}

}
class Queue2{
	private int maxsize;
	private int front;
	private int rear;
	private char qarr[];
	private int nitems;
	
	public Queue2(int msz) {
		maxsize = msz;
		qarr = new char[maxsize];
		front = 0;
		rear = -1;
		nitems = 0;
	}
	public void insertq(char data) {
		if(nitems == maxsize) {
			System.out.println("Queue is Full");
		}else if(rear == maxsize-1){
			rear = -1;
		}
		qarr[++rear] = data;
		nitems++;
	}
	public char reamove() { //we should deffenitly use "temp" in circular queue's remove function"
	    if (nitems == 0) {
	        System.out.println("Queue is Empty");
	        return '\0';
	    }
	    char temp = qarr[front++]; //declare temp mvariable
	    if (front == maxsize) {
	        front = 0; // wrap around
	    }
	    nitems--;
	    return temp;
	}

}

public class circularQwithStack {
	public static void main(String[] args) {
		Stack2 st1 = new Stack2(4);
		Queue2 q1 = new Queue2(8);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter at least 4 characters: ");
		String str = sc.next();

		if (str.length() < 4) {
		    System.out.println("Input too short!");
		    return;
		}

		for(int i=0;i<4;i++) {
			st1.insert(str.charAt(i));
			q1.insertq(str.charAt(i));
		}	
		for(int i=4;i<8;i++) {
			q1.insertq(st1.pop());
		}
		for(int i=0;i<8;i++) {
			System.out.print(q1.reamove());
		}

	}
}