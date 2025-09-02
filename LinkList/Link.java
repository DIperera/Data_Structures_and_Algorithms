package linklistpkg;

public class Link {
    public int iData;    // data item
    public Link next;    // reference to the next link

    public Link(int id) {
        iData = id;
        next = null;
    }

    public void displayLink() {
        System.out.println(iData);
    }
}

