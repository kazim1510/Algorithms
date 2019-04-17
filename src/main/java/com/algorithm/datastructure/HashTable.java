package com.algorithm.datastructure;

public class HashTable {

    private int INITITAL_SIZE = 16;
    private HashEntry[] data;

    public static class HashEntry {
        private String key;
        private String value;
        private HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        data = new HashEntry[INITITAL_SIZE];
    }


    public void put(String key, String val) {

        HashEntry entry = new HashEntry(key, val);
        int index = getIndex(key);

        if (data[index] == null) {
            data[index] = entry;
        } else {
            HashEntry exEntry = data[index];
            while (exEntry.next != null) {
                exEntry = exEntry.next;
            }
            exEntry.next = entry;
        }
    }

    public String get(String key) {
        int index = getIndex(key);
        HashEntry entry = data[index];
        if (entry == null) {
            return null;
        } else {
            while (!entry.key.equals(key)) {
                entry = entry.next;
            }
            return entry.value;
        }
    }

    private int getIndex(String key) {
        return key.hashCode() % INITITAL_SIZE;
    }
}
