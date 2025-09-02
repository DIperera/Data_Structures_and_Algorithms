package linklistpkg;

class MyList {
    public static void main(String[] args) {
        LinkList theList = new LinkList();    // create a new list

        theList.insertFirst(23);    // insert four items
        theList.insertFirst(89);
        theList.insertFirst(12);
        theList.insertFirst(55);

        // After insert(100, 12)
        theList.insert(100, 12);

        // After display
        System.out.print("List: ");
        theList.displayList();

        // After delete(100)
        Link deleted100 = theList.delete(100);
        System.out.print("Deleted ");
        if (deleted100 != null) deleted100.displayLink();

        // After deleteFirst()
        Link deletedFirst = theList.deleteFirst();
        System.out.print("DeletedFirst ");
        if (deletedFirst != null) deletedFirst.displayLink();

        // After delete(89)
        Link deleted89 = theList.delete(89);
        System.out.print("Deleted ");
        if (deleted89 != null) deleted89.displayLink();

        // After delete(12)
        Link deleted12 = theList.delete(12);
        System.out.print("Deleted ");
        if (deleted12 != null) deleted12.displayLink();

        // After delete(23)
        Link deleted23 = theList.delete(23);
        System.out.print("Deleted ");
        if (deleted23 != null) deleted23.displayLink();

        // Final list state
        System.out.print("Final List: ");
        theList.displayList();
    }
}

