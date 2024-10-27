package org.container;

/**
 * The Container class represents a container for storing objects.
 */
public class Container {

    /**
     * The inner Node class represents a node in the list.
     */
    static class Node {
        Object obj;
        Node next;

        /**
         * Constructor to create a new node with the given value.
         *
         * @param value the value of the node
         */
        Node(Object value) {
            obj = value;
            next = null;
        }
    }

    int amount_elem;
    Node head;

    /**
     * Default constructor to create an empty container.
     */
    public Container() {
        amount_elem = 0;
        head = null;
    }

    /**
     * Constructor to create a container with one element.
     *
     * @param value the value of the element
     */
    public Container(Object value) {
        amount_elem = 1;
        head = new Node(value);
    }

    /**
     * Returns the value of the element at the specified position.
     *
     * @param place the position of the element
     * @return the value of the element
     */
    public Object get_value(int place) {
        Node helper = head;
        for (int i = 0; i < place - 1; i++) {
            helper = helper.next;
        }
        return helper.obj;
    }

    /**
     * Returns the number of elements in the container.
     *
     * @return the number of elements
     */
    public int get_lenght() {
        return amount_elem;
    }

    /**
     * Returns the string representation of the container.
     *
     * @return the string representation of the container
     */
    @Override
    public String toString() {
        String output_str = "Container:\n";
        Node helper = head;
        while (helper.next != null) {
            output_str += helper.obj.toString() + " ";
            helper = helper.next;
        }
        output_str += helper.obj.toString() + " ";
        return output_str;
    }

    /**
     * Returns the hash code of the container.
     *
     * @return the hash code of the container
     */
    @Override
    public int hashCode() {
        if (head.next != null) {
            return 53 * head.obj.hashCode() + 24 * head.next.obj.hashCode() + 211;
        } else {
            return 53 * head.obj.hashCode() + 211;
        }
    }

    /**
     * Compares this container with another object.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Container)) return false;
        Container other = (Container) obj;
        if (other.get_lenght() != amount_elem) return false;
        Node helper = head;
        int counter = 1;
        while (helper.next != null) {
            if (!helper.obj.equals(other.get_value(counter))) {
                return false;
            }
            helper = helper.next;
            counter++;
        }
        return true;
    }

    /**
     * Adds an element at the specified position.
     *
     * @param place the position to add the element
     * @param value the value of the element
     */
    public void add_to(int place, Object value) {
        Node helper;
        if (place == 1) {
            helper = new Node(value);
            helper.next = head;
            head = helper;
        } else if (place > amount_elem) {
            helper = head;
            while (helper.next != null) {
                helper = helper.next;
            }
            helper.next = new Node(value);
        } else {
            helper = head;
            for (int i = 0; i < place - 1; i++) {
                helper = helper.next;
            }
            Node new_elem = new Node(value);
            new_elem.next = helper.next;
            helper.next = new_elem;
        }
        amount_elem += 1;
    }

    /**
     * Adds an element to the end of the container.
     *
     * @param value the value of the element
     */
    public void add(Object value) {
        add_to(amount_elem + 1, value);
    }

    /**
     * Removes the element at the specified position.
     *
     * @param place the position of the element to remove
     */
    public void remove(int place) {
        if (place == 1) {
            head = head.next;
        } else if (place >= amount_elem) {
            Node helper = head;
            while (helper.next.next != null) {
                helper = helper.next;
            }
            helper.next = null;
        } else {
            Node helper = head;
            for (int i = 0; i < place - 2; i++) {
                helper = helper.next;
            }
            helper.next = helper.next.next;
        }
        amount_elem -= 1;
    }
}