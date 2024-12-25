package filfile_project_3;

class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    @Override
    public int compareTo(Node<T> t) {
        return this.element.compareTo(t.element);
    }
}

public class LinkedList<T extends Comparable<T>> {

    /**
     * instance variables for the list
     */
    private Node<T> head;

    /**
     * Constructor to create an empty list
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Return the first element in the list
     *
     * @return
     */
    public T getFirst() {
        if (this.head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Add an element to the beginning of the list
     * @param item
     */
    public void insertItem(T item) {
        Node<T> newNode = new Node<T>(item); // Create a new node

        if (head == null) {
            newNode.next = head;
            head = newNode;
        } 
        else if (head.element.compareTo(item) >0) {
            newNode.next = head;
            head = newNode;
        } 
        else {
            Node<T> temp = this.head;
            while (temp.next != null && temp.next.element.compareTo(item) < 0) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public T retrieveItem(T item) {
        boolean found = false;
        Node<T> currentNode = this.head;
        while (currentNode != null && !found) {
            if (currentNode.element.equals(item)) {
                return currentNode.element;   //returns the address so can just update the count in main
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    @Override
    /**
     * Override toString() to return elements in the list
     */
    public String toString() {
        String result = "";

        Node<T> currentNode = this.head;
        while (currentNode != null) {
            result = result + currentNode.element.toString();
            currentNode = currentNode.next;
            if (currentNode != null) {
                result = result + ", "; // Separate elements with a comma
            }
        }
        return result;
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = null;
    }

}
