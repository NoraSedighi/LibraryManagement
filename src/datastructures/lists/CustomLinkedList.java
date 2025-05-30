package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null){
            throw new NoSuchElementException("list must not be empty");
        }

        T data = head.data;
        head =  head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;

        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("list must not be empty");
        }

        T data = tail.data;
        tail = tail.prev;

        if (tail == null)
            head = null;
        else
            tail.next = null;

        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("list must not be empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("list must not be empty");
        }
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object get(int index) {
        return nodeAt(index).data;
    }

    @Override
    public Object set(int index, Object element) {
        Node<T> node = nodeAt(index);
        T old = node.data;
        node.data = (T) element;
        return old;
    }

    @Override
    public boolean add(Object o) {
        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (!current.equals(o)) continue;

            if (current == head) {
                removeFirst();
            } else if (current == tail) {
                removeLast();
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
            }

            return true;
        }
        return false;
    }

    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + "\tsize: " + size);
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i < index; i--)
                current = current.prev;
        }
        return current;
    }
}