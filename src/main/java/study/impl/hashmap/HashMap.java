package study.impl.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> {
    Object[] datumKey;
    Object[] datumValue;
    int size;

    HashMap() {
        datumKey = new Object[2];
        datumValue = new Object[2];
        int size = 0;
    }

    public void findAll() {
        System.out.println("size = " + size);
        for (int i = 0; i < size; i++) {
            System.out.println("datumKey[" + i + "] = " + datumKey[i]);
            System.out.println("datumValue[" + i + "] = " + datumValue[i]);
        }
    }

    public void put(K key, V value) {
        sizeUpIfFull();
        if (isExistKey(key)) {
            changeValue(key, value);
        } else {
            datumKey[size] = key;
            datumValue[size] = value;
            size++;
        }
    }
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();

        for ( int i = 0; i < size; i++ ) {
            keySet.add((K)datumKey[i]);
        }
        return keySet;
    }
    public boolean isExistKey(K key) {
        for (int i = 0; i < datumKey.length; i++) {
            if (datumKey[i] == key) {
                return true;
            }
        }
        return false;
    }

    public void changeValue(K key, V value) {
        for (int i = 0; i < datumKey.length; i++) {
            if (datumKey[i] == key) {
                datumValue[i] = value;
            }
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < datumKey.length; i++) {
            if (datumKey[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public void remove(K key) {
        int idx = findIndex(key);
        for (int i = idx + 1; i < size; i++) {
            datumKey[i - 1] = datumKey[i];
            datumValue[i - 1] = datumValue[i];
        }
        size--;
    }

    public void sizeUpIfFull() {
        if (isFull()) {
            sizeUp();
        }
    }

    public boolean isFull() {
        return size == datumKey.length;
    }

    private void sizeUp() {
        Object[] newDatumKey = new Object[datumKey.length * 2];
        Object[] newDatumValue = new Object[datumKey.length * 2];

        for ( int i = 0; i < datumKey.length; i++ ) {
            newDatumKey[i] = datumKey[i];
            newDatumValue[i] = datumValue[i];
        }

        datumKey = newDatumKey;
        datumValue = newDatumValue;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (datumKey[i].equals(key)) {
                return (V)datumValue[i];
            }
        }
        return null;
    }
}
