package pro.boto.datatype.classifiers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimitiveClassifierTest {

    private final static boolean BOOL = true;
    private final static byte BYTE = 1;
    private final static char CHAR = '1';
    private final static double DOUBLE = 1D;
    private final static float FLOAT = 1F;
    private final static int INT = 1;
    private final static long LONG = 1L;
    private final static short SHORT = 1;

    @Test
    public void isBoolean(){
        assertTrue(Classifier.isBoolean(BOOL));
        assertFalse(Classifier.isBoolean(BYTE));
        assertFalse(Classifier.isBoolean(CHAR));
        assertFalse(Classifier.isBoolean(DOUBLE));
        assertFalse(Classifier.isBoolean(FLOAT));
        assertFalse(Classifier.isBoolean(INT));
        assertFalse(Classifier.isBoolean(LONG));
        assertFalse(Classifier.isBoolean(SHORT));
    }

    @Test
    public void isByte(){
        assertFalse(Classifier.isByte(BOOL));
        assertTrue(Classifier.isByte(BYTE));
        assertFalse(Classifier.isByte(CHAR));
        assertFalse(Classifier.isByte(DOUBLE));
        assertFalse(Classifier.isByte(FLOAT));
        assertFalse(Classifier.isByte(INT));
        assertFalse(Classifier.isByte(LONG));
        assertFalse(Classifier.isByte(SHORT));
    }

    @Test
    public void isChar(){
        assertFalse(Classifier.isChar(BOOL));
        assertFalse(Classifier.isChar(BYTE));
        assertTrue(Classifier.isChar(CHAR));
        assertFalse(Classifier.isChar(DOUBLE));
        assertFalse(Classifier.isChar(FLOAT));
        assertFalse(Classifier.isChar(INT));
        assertFalse(Classifier.isChar(LONG));
        assertFalse(Classifier.isChar(SHORT));
    }

    @Test
    public void isDouble(){
        assertFalse(Classifier.isDouble(BOOL));
        assertFalse(Classifier.isDouble(BYTE));
        assertFalse(Classifier.isDouble(CHAR));
        assertTrue(Classifier.isDouble(DOUBLE));
        assertFalse(Classifier.isDouble(FLOAT));
        assertFalse(Classifier.isDouble(INT));
        assertFalse(Classifier.isDouble(LONG));
        assertFalse(Classifier.isDouble(SHORT));
    }

    @Test
    public void isFloat(){
        assertFalse(Classifier.isFloat(BOOL));
        assertFalse(Classifier.isFloat(BYTE));
        assertFalse(Classifier.isFloat(CHAR));
        assertFalse(Classifier.isFloat(DOUBLE));
        assertTrue(Classifier.isFloat(FLOAT));
        assertFalse(Classifier.isFloat(INT));
        assertFalse(Classifier.isFloat(LONG));
        assertFalse(Classifier.isFloat(SHORT));
    }

    @Test
    public void isInteger(){
        assertFalse(Classifier.isInteger(BOOL));
        assertFalse(Classifier.isInteger(BYTE));
        assertFalse(Classifier.isInteger(CHAR));
        assertFalse(Classifier.isInteger(DOUBLE));
        assertFalse(Classifier.isInteger(FLOAT));
        assertTrue(Classifier.isInteger(INT));
        assertFalse(Classifier.isInteger(LONG));
        assertFalse(Classifier.isInteger(SHORT));
    }

    @Test
    public void isLong(){
        assertFalse(Classifier.isLong(BOOL));
        assertFalse(Classifier.isLong(BYTE));
        assertFalse(Classifier.isLong(CHAR));
        assertFalse(Classifier.isLong(DOUBLE));
        assertFalse(Classifier.isLong(FLOAT));
        assertFalse(Classifier.isLong(INT));
        assertTrue(Classifier.isLong(LONG));
        assertFalse(Classifier.isLong(SHORT));
    }

    @Test
    public void isShort(){
        assertFalse(Classifier.isShort(BOOL));
        assertFalse(Classifier.isShort(BYTE));
        assertFalse(Classifier.isShort(CHAR));
        assertFalse(Classifier.isShort(DOUBLE));
        assertFalse(Classifier.isShort(FLOAT));
        assertFalse(Classifier.isShort(INT));
        assertFalse(Classifier.isShort(LONG));
        assertTrue(Classifier.isShort(SHORT));
    }


}
