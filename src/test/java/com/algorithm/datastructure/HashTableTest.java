package com.algorithm.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {

    private HashTable table;

    @Before
    public void setUp() throws Exception {
        table = new HashTable();
    }

    @Test
    public void testHashTable() throws Exception {
        table.put("23311", "hello");
        table.put("23312", "how");
        table.put("23313", "are");
        table.put("23314", "you?");

        assertEquals("hello", table.get("23311"));
        assertEquals("how", table.get("23312"));
        assertEquals("are", table.get("23313"));
        assertNotEquals("are", table.get("23314"));
    }
}
