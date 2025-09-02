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
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

/*
 * Internal State Transitions of Linked List
 *
 * | Operation        | List State (from `first`)        |
 * |------------------|----------------------------------|
 * | After insert 23  | 23                               |
 * | After insert 89  | 89 → 23                          |
 * | After insert 12  | 12 → 89 → 23                     |
 * | After insert 55  | 55 → 12 → 89 → 23                |
 * | After display    | Prints: 55, 12, 89, 23           |
 * | After delete 55  | 12 → 89 → 23                     |
 * | After delete 12  | 89 → 23                          |
 * | After delete 89  | 23                               |
 * | After delete 23  | (empty)                          |
 */
