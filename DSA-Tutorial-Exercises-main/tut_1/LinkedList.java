package tut_1;

public class LinkedList<E> implements List<E> {

    // Generic Node inner class
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    // Add a node with generic data to the end of the list
    @Override
    public void add(E data) {
        if (head == null) {
            // TODO: Create a new node with 'data' and attach it to the end of the list
            head = new Node<E>(data);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            // TODO: Create a new node with 'data' and attach it to the end of the list
            current.next = new Node<>(data);
        }
    }

    // Find a node with generic data in the list
    @Override
    public boolean find(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Data found
            }
            current = current.next;
        }
        return false; // Data not found
    }

    // Remove a node with generic data from the list
    @Override
    public void remove(E data) {
        // TODO: Implement this method
        Node<E> current = head;
        Node<E> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            // Found the node with the given data, update the links to remove it
            if (prev == null) {
                // Node to be removed is the head
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    // Print the linked list
    @Override
    public void printList() {
        // TODO: Implement this method
    }

    // Get the size of the list
    @Override
    public int size() {
        // TODO: Implement this method
    }
}
