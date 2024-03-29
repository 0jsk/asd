package ru.scndjk.dsa.LinkedList2;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node temp = head;

        while (temp != null) {
            if (temp.value == _value) {
                return temp;
            }

            temp = temp.next;
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
        Node temp = find(_value);

        if (temp == null) {
            return false;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        return true;
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
            _nodeToInsert.prev = null;
            head = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
        }

        if (tail == _nodeAfter) {
            tail = _nodeToInsert;
        }
    }

    public void insertFirst(Node _first) {
        insertAfter(null, _first);
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
