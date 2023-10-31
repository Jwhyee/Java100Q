package study.impl.list.array;

import study.impl.list.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private Object[] datum;
    private int size;

    public ArrayList() {
        datum = new Object[2];
        size = 0;
    }

    public void add(E data) {
        sizeUpIfFull();
        datum[size] = data;
        size++;
    }

    public void sizeUpIfFull() {
        if (isFull()) {
            sizeUp();
        }
    }

    private void sizeUp() {
        Object[] newDatum = new Object[datum.length * 2];

        for ( int i = 0; i < datum.length; i++ ) {
            newDatum[i] = datum[i];
        }

        datum = newDatum;
    }

    public boolean isFull() {
        return size == datum.length;
    }

    public E get(int idx) {
        return (E)datum[idx];
    }

    public void removeAt(int idx) {
        for (int i = idx + 1; i < size; i++) {
            datum[i - 1] = datum[i];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(datum[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }

    public int size() {
        return size;
    }
}
