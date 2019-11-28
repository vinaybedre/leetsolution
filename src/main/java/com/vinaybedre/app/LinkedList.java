package com.vinaybedre.app;

public class LinkedList {

    public <T> void appendToEnd(Node head, T element) {
        Node current = head;
        if (current == null) {
            current = new Node<>(element);
            head = current;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(element);
    }

    public void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " --> ");
            current = current.next;
        }
    }
}
