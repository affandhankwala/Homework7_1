import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
   
    @Test
    public void remove() {
        ArrayDictionary dict1 = new ArrayDictionary(0);
        assertFalse(dict1.remove(3));

        ArrayDictionary dict2 = new ArrayDictionary(5);
        dict2.add(1, 23);
        dict2.add(0, 13);
        dict2.add(2, 14);
        assertTrue(dict2.remove(2));        //Test remove key
        assertFalse(dict2.remove(2));       //Test remove removed key
        assertTrue(dict2.remove(1));        //Test remove key
        assertFalse(dict2.remove(4));       //Test remove nonexistent key

        ArrayDictionary dict3 = new ArrayDictionary(5);
        dict3.add(0, 23);
        dict3.add(1, 14);
        dict3.add(5, 25);
        dict3.add(10, 129);
        assertTrue(dict3.remove(1));        //Test remove key in non collision
        assertTrue(dict3.remove(5));        //Test remove key in collision
        assertFalse(dict3.remove(3));       //Test remove removed key in collision
        assertFalse(dict3.remove(11));      //Test remove nonexistent key in collision

    }

    @Test
    public void contains() {
        ArrayDictionary dict = new ArrayDictionary(0);
        assertFalse(dict.contains(-1));         //Test empty dict
        assertFalse(dict.contains(0));
        assertFalse(dict.contains(1));

        ArrayDictionary dict1 = new ArrayDictionary(1);
        dict1.add(0, 103);
        assertFalse(dict1.contains(2));
        assertTrue(dict1.contains(0));

        ArrayDictionary dict2 = new ArrayDictionary(2);
        dict2.add(0, 103);
        dict2.add(1, 105);
        assertTrue(dict2.contains(0));
        assertTrue(dict2.contains(1));
        assertFalse(dict2.contains(2));

        ArrayDictionary dict3 = new ArrayDictionary(3);
        dict3.add(0, 103);
        dict3.add(1, 105);
        assertFalse(dict3.contains(3));
        dict3.add(2, 206);
        assertTrue(dict3.contains(1));

        ArrayDictionary dict4 = new ArrayDictionary(3);
        dict4.add(0, 103);
        dict4.add(1, 105);
        dict4.add(2, 206);
        dict4.add(4, 407);
        assertTrue(dict4.contains(1));
        assertTrue(dict4.contains(4));
        assertFalse(dict4.contains(7));
        assertFalse(dict4.contains(8));
    }
}