package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index + "size: " + size);
    }

    private static <T> T checkNull(T object, String message) {
        if (object == null)
            throw new NullPointerException(message);
        return object;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
         checkNull(element, "element must not be null");
         checkIndex(index);
         T old =  (T) elements[index];
         elements[index] = element;
         return old;
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
    public boolean add(Object o) {
        checkNull(o, "element must not be null");
        ensureCapacity();
        elements[size++] = o;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        checkNull(o, "element must not be null");
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        checkNull(o, "element must not be null");
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                int numMoved = size - i - 1;
                if (numMoved > 0)
                    System.arraycopy(elements, i + 1, elements, i, numMoved);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

}