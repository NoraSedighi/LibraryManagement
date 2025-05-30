package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    private static <T> T checkNull(T object, String message) {
        if (object == null)
            throw new NullPointerException(message);
        return object;
    }
    @Override
    public boolean add(Object t) {
        if (offer(t))
            return true;
        throw new IllegalStateException("Queue full!");
    }

    @Override
    public boolean offer(Object t) {
        checkNull(t, "element must not be null");
        list.addLast((T) t);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;
        else
            return list.removeFirst();
    }

    @Override
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        else
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