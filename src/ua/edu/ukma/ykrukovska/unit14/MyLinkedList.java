package ua.edu.ukma.ykrukovska.unit14;

public class MyLinkedList<T> implements MyList<T> {

    private Node head;
    private Node tail;
    private int size;

    /**
     * @param e value null is not allowed
     * @throws IllegalArgumentException
     */

    @Override
    public void add(T e) {
        if (e == null) {
            throw new IllegalArgumentException("Null value is not supported. Sorry, Kyrienko Oksana");
        }
        if (head == null) {
            head = new Node<T>(e, null);
            tail = head;
        } else {
            Node newNode = new Node<T>(e, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void delete(T e) {

        if (head == null) {
            return;
        }

        if (head.value.equals(e)) {
            head = head.next;
            size--;
            return;
        }

        Node currentNode = head;
        Node previousNode = null;

        do {

            if (!currentNode.value.equals(e)) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else if (currentNode.value.equals(e)) {
                previousNode.next = currentNode.next;
                size--;
                return;
            }

        } while (currentNode != tail);

        if (tail.value.equals(e)) {
            tail = previousNode;
            tail.next = null;
            size--;
        }


    }

    @Override
    public T get(int i) {
        Node<T> currentNode = head;
        int counter = 0;

        if (i > size) {
            return null;
        }

        while (counter <= i) {
            if (counter == i) {
                return currentNode.value;
            }

            currentNode = currentNode.next;
            counter++;

        }


        return null;
    }

    @Override
    public boolean contains(T e) {
        Node currentNode = head;


        do {

            if (!currentNode.value.equals(e)) {

                currentNode = currentNode.next;
            } else if (currentNode.value.equals(e)) {

                return true;

            }

        } while (currentNode != tail);

        return currentNode.value.equals(e);
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {

        T value;
        Node next;


        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
