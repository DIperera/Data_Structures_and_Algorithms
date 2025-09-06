package linklistpkg;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id) { //Each call to insertFirst(id) creates a new Link node with the given value.The new node is inserted at the beginning of the list.
        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() { //Each iteration Removes the first node (deleteFirst()). The loop continues until the list is empty.
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() { //This function traverses the list from first to null, printing each node’s iData.
        Link current = first;  //create a link called current
        while (current != null) { //current link starts travelling from first link
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
    
    // Finds and returns the Link node with the given id, or null if not found
    public Link find(int id) {
        Link current = first;  //create a link called current
        while (current != null) { // current link starts travelling from first link until the "id" is found
            if (current.iData == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Inserts a new Link node with the given id after the node with the given key
    public void insert(int id, int key) {

        Link current = first;  //create a link called current
        while (current != null && current.iData != key) { 
            current = current.next;
        }
        if (current != null) { // If the key is found, insert the new link after the current link
            Link newLink = new Link(id);
            newLink.next = current.next;
            current.next = newLink;
        }
        // If key not found, do not insert
    }

// Deletes the node with the given id from the list
    public Link delete(int id) { //return type is Link
        
        Link current = first;
        Link previous = null;
        while (current != null && current.iData != id) {
            previous = current; //#entire node will be assigned to previous#
            current = current.next;
        }
        if (current == null) {
            return null; // Not found
        }
        if (previous == null) {
            // Deleting the first node
            first = first.next;
        } else {
            previous.next = current.next; //eventually the node we want to delete should have been the current. Always 'Previous' is the link which is before the Current
        }
        return current;
    }

}

/*
 * Internal State Transitions of Linked List (with insert after key and delete by id)
 *
 * | Operation                | List State (from `first`)        |
 * |--------------------------|----------------------------------|
 * | After insertFirst(23)    | 23                               |
 * | After insertFirst(89)    | 89 → 23                          |
 * | After insertFirst(12)    | 12 → 89 → 23                     |
 * | After insertFirst(55)    | 55 → 12 → 89 → 23                |
 * | After insert(100, 12)    | 55 → 12 → 100 → 89 → 23          |
 * | After display            | Prints: 55, 12, 100, 89, 23      |
 * | After delete(100)        | 55 → 12 → 89 → 23                |
 * | After deleteFirst()      | 12 → 89 → 23                     |
 * | After delete(89)         | 12 → 23                          |
 * | After delete(12)         | 23                               |
 * | After delete(23)         | (empty)                          |
 */
