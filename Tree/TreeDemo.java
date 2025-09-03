package pkg1;

//Node class
class Node {
 public int iData;       // data item (used as key value)
 public double dData;    // other data
 public Node leftChild;  // this node’s left child
 public Node rightChild; // this node’s right child

 public void displayNode() {
     System.out.print("{ ");
     System.out.print(iData);
     System.out.print(", ");
     System.out.print(dData);
     System.out.print(" } ");
 }
}

//Tree class
class Tree {
 private Node root; // first node of tree

 public Tree() {
     root = null;
 }

 // Insert method
 public void insert(int id, double dd) {
     Node newNode = new Node();
     newNode.iData = id;
     newNode.dData = dd;

     if (root == null) { // no node in root
         root = newNode;
     } else {            // root occupied
         Node current = root;
         Node parent;
         while (true) {
             parent = current;
             if (id < current.iData) { // go left
                 current = current.leftChild;
                 if (current == null) {
                     parent.leftChild = newNode;
                     return;
                 }
             } else { // go right
                 current = current.rightChild;
                 if (current == null) {
                     parent.rightChild = newNode;
                     return;
                 }
             }
         }
     }
 }

 // Find method
 public Node find(int key) {
     Node current = root;
     while (current != null && current.iData != key) {
         if (key < current.iData) {
             current = current.leftChild;
         } else {
             current = current.rightChild;
         }
     }
     return current; // null if not found
 }

 // Delete method
 public boolean delete(int key) {
     Node current = root;
     Node parent = root;
     boolean isLeftChild = true;

     // Find the node
     while (current != null && current.iData != key) {
         parent = current;
         if (key < current.iData) {
             isLeftChild = true;
             current = current.leftChild;
         } else {
             isLeftChild = false;
             current = current.rightChild;
         }
     }

     if (current == null) return false; // not found

     // Case 1: no children
     if (current.leftChild == null && current.rightChild == null) {
         if (current == root) root = null;
         else if (isLeftChild) parent.leftChild = null;
         else parent.rightChild = null;
     }
     // Case 2: one child (left only)
     else if (current.rightChild == null) {
         if (current == root) root = current.leftChild;
         else if (isLeftChild) parent.leftChild = current.leftChild;
         else parent.rightChild = current.leftChild;
     }
     // Case 2: one child (right only)
     else if (current.leftChild == null) {
         if (current == root) root = current.rightChild;
         else if (isLeftChild) parent.leftChild = current.rightChild;
         else parent.rightChild = current.rightChild;
     }
     // Case 3: two children
     else {
         Node successor = getSuccessor(current);

         if (current == root) root = successor;
         else if (isLeftChild) parent.leftChild = successor;
         else parent.rightChild = successor;

         successor.leftChild = current.leftChild;
     }
     return true;
 }

 // Get successor (used in delete for two children)
 private Node getSuccessor(Node delNode) {
     Node successorParent = delNode;
     Node successor = delNode;
     Node current = delNode.rightChild;

     while (current != null) {
         successorParent = successor;
         successor = current;
         current = current.leftChild;
     }

     if (successor != delNode.rightChild) {
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode.rightChild;
     }
     return successor;
 }

 // Traversals
 private void inOrder(Node localRoot) {
     if (localRoot != null) {
         inOrder(localRoot.leftChild);
         localRoot.displayNode();
         inOrder(localRoot.rightChild);
     }
 }

 private void preOrder(Node localRoot) {
     if (localRoot != null) {
         localRoot.displayNode();
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
     }
 }

 private void postOrder(Node localRoot) {
     if (localRoot != null) {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         localRoot.displayNode();
     }
 }

 // Public wrappers for traversals
 public void inOrder() {
     inOrder(root);
     System.out.println();
 }

 public void preOrder() {
     preOrder(root);
     System.out.println();
 }

 public void postOrder() {
     postOrder(root);
     System.out.println();
 }
}

//Main class
public class TreeDemo {
 public static void main(String[] args) {
     Tree tree = new Tree();

     // Insert some nodes
     tree.insert(50, 1.5);
     tree.insert(30, 1.7);
     tree.insert(70, 1.9);
     tree.insert(20, 1.2);
     tree.insert(40, 1.4);
     tree.insert(60, 1.6);
     tree.insert(80, 1.8);

     // Display traversals
     System.out.println("Inorder traversal:");
     tree.inOrder();

     System.out.println("Preorder traversal:");
     tree.preOrder();

     System.out.println("Postorder traversal:");
     tree.postOrder();

     // Find
     System.out.println("Find 40: " + (tree.find(40) != null));
     System.out.println("Find 100: " + (tree.find(100) != null));

     // Delete
     tree.delete(20);
     System.out.println("After deleting 20 (inorder):");
     tree.inOrder();

     tree.delete(30);
     System.out.println("After deleting 30 (inorder):");
     tree.inOrder();
 }
}

