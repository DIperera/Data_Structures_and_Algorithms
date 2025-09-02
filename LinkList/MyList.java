package linklistpkg;

class MyList {
    public static void main(String[] args) {
        LinkList theList = new LinkList();    // create a new list

        theList.insertFirst(23);    // insert four items
        theList.insertFirst(89);
        theList.insertFirst(12);
        theList.insertFirst(55);

        theList.displayList();      // display the list

        while (!theList.isEmpty()) {   // delete item one by one
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
        }
    }
}

