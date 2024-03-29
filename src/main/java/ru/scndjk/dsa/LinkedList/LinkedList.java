package ru.scndjk.dsa.LinkedList;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node temp = head;
        while (temp != null) {
            if (temp.value == _value) {
                nodes.add(temp);
            }

            temp = temp.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        if (head == null) {
            return false;
        }

        if (head.value == _value) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            return true;
        }

        Node temp = head;
        while (temp.next != null && temp.next.value != _value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            if (temp.next == tail) {
                tail = temp;
            }

            temp.next = temp.next.next;

            return true;
        }

        return false;
    }

    public void removeAll(int _value) {
        while (remove(_value)) {
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int count() {
        int length = 0;

        Node temp = head;
        while (temp != null) {
            length += 1;
            temp = temp.next;
        }

        return length;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }

        if (tail == _nodeAfter) {
            tail = _nodeToInsert;
        }
    }

    public static LinkedList sumBoth(LinkedList list1, LinkedList list2) {
        if (list1.count() != list2.count()) {
            throw new IllegalArgumentException("Provided LinkedLists are not equal in length");
        }

        LinkedList result = new LinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while (temp1 != null) {
            int sum = temp1.value + temp2.value;

            temp1 = temp1.next;
            temp2 = temp2.next;

            Node newNode = new Node(sum);
            result.addInTail(newNode);
        }

        return result;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}

