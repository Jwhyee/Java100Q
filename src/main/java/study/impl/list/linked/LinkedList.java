package study.impl.list.linked;

import study.impl.list.List;

public class LinkedList<E> implements List<E> {
    private int size;
    Node<E> first;
    Node<E> last;

    public LinkedList() {
        this.size = 0;
    }

    public void add(E o) {
        linkLast(o);
    }

    @Override
    public E get(int idx) {
        if(idx > size) return null;

        int i = 0;
        for (Node<E> x = first; x != null;) {
            if (i == idx) {
                return x.item;
            }
            x = x.next;
            i++;
        }
        return null;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if(l == null) first = newNode;
        else l.next = newNode;

        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Node<E> x = first; x != null; ) {
            sb.append(x.item).append(", ");
            x = x.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
