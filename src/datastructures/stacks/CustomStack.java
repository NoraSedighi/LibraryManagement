package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        return offer(t);
    }

    @Override
    public boolean offer(Object t) {
        if (t == null)
            throw new NullPointerException("element must not be null");
        list.addFirst((T) t);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;
        return list.removeFirst();
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}