package ru.scndjk.dsa.OrderedList;

import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    @SuppressWarnings("unchecked")
    public int compare(T v1, T v2) {
        if (v1 instanceof String s1 && v2 instanceof String s2) {
            String t1 = s1.trim();
            String t2 = s2.trim();

           int cmp = t1.compareTo(t2);

           if (cmp == 0) {
               return 0;
           }

           return cmp < 0 ? -1 : 1;
        }

        if (v1 instanceof Comparable c1 && v2 instanceof Comparable c2) {
            return c1.compareTo(c2);
        }

        return 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<T> current = head;

            while (current != null) {
                int cmp = compare(value, current.value);

                if ((_ascending && cmp <= 0) || (!_ascending && cmp >= 0)) {
                    break;
                }

                current = current.next;
            }

            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
    }

    public Node<T> find(T val) {
        Node<T> current = head;

        while (current != null) {
            int cmp = compare(val, current.value);

            if (cmp == 0) {
                return current;
            } else if ((_ascending && cmp < 0) || (!_ascending && cmp > 0)) {
                break;
            }

            current = current.next;
        }

        return null;
    }

    public void delete(T val) {
        Node<T> current = head;

        while (current != null) {
            if (compare(current.value, val) == 0) {
                if (current == head) {
                    head = current.next;

                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                break;
            }

            current = current.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count() {
        int length = 0;

        Node<T> current = head;
        while (current != null) {
            length += 1;
            current = current.next;
        }

        return length;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}

