package pkg1;

public class QueueX {
    private int maxSize;    // size of queue array
    private int[] queArray;
    private int front;      // front of the queue
    private int rear;       // rear of the queue
    private int nItems;     // no of items of the queue

    public QueueX(int s) {  // constructor
        maxSize = s;        // set array size
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;         // no items
    }

    public void insert(int j) {
        // check whether queue is full
        if (rear == maxSize - 1)
            System.out.println("Queue is full");
        else {
            queArray[++rear] = j;
            nItems++;
        }
    }
    
    public int remove() {
        if (nItems == 0) {
            System.out.println("Queue is empty");
            return -99;
        } else {
            nItems--;
            return queArray[front++];
        }
    }

    public int peekFront() {
    	if(nItems == 0) {
    		System.out.println("Queue is Empty");
    		return -99;
    	}
    	else {
    		return queArray[front];
    	}
    }
    
    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (rear == maxSize - 1);
    }

}

