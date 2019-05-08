package com.algorithm.datastructure;

public class DynamicArray {

    private Object[] data;
    private int size;
    private int initialCapasity;

    public DynamicArray(int initialCapasity) {
        this.initialCapasity = initialCapasity;
        data = new Object[initialCapasity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        if (size == initialCapasity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public void delete(int index) {

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isEmptry(int index) {
        return size == 0;
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        Object[] newD = new Object[initialCapasity * 2];
        for (int i = 0; i < size; i++) {
            newD[i] = data[i];
        }
        this.data = newD;
        initialCapasity = initialCapasity * 2;
    }

    public void add(String val) {

    }

}
