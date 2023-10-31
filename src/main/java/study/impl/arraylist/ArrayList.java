package study.impl.arraylist;

public class ArrayList<T> {
    private Object[] datum;
    private int size;

    ArrayList() {
        datum = new Object[2];
        size = 0;
    }

    public void add(Object data) {
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

    public T get(int idx) {
        return (T)datum[idx];
    }

    public void removeAt(int idx) {
        for (int i = idx + 1; i < size; i++) {
            datum[i - 1] = datum[i];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int getArrayLength() {
        return datum.length;
    }

    public void showAllValues() {
        System.out.println("== 전체 데이터 출력 ==");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + datum[i]);
        }
    }
}
