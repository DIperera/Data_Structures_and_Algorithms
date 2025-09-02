package pkg1;

public class QueueApp {
    public static void main(String[] args) {
        QueueX theQueue = new QueueX(10);  // create a queue with max size 10

        theQueue.insert(10);  // insert given items
        theQueue.insert(25);
        theQueue.insert(55);
        theQueue.insert(65);
        theQueue.insert(85);

        while( !theQueue.isEmpty() ) {  // until it is empty, delete item from queue
            System.out.println(theQueue.remove());
        }
    }
}  // end of class

