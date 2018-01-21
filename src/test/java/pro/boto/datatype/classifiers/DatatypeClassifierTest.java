package pro.boto.datatype.classifiers;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatatypeClassifierTest {

    private final static int INT = 1;
    private final static long LONG = 1L;
    private final static double DOUBLE = 1D;
    private final static float FLOAT = 1F;
    private final static boolean BOOL = true;
    private final static byte BYTE = 1;
    private final static short SHORT = 1;
    private final static char CHAR = '1';

    private final static String STRING = "1";
    private final static Date DATE = new Date();


    @Test
    public void isDate(){
        assertFalse(Classifier.isDate(INT));
        assertFalse(Classifier.isDate(LONG));
        assertFalse(Classifier.isDate(DOUBLE));
        assertFalse(Classifier.isDate(FLOAT));
        assertFalse(Classifier.isDate(BOOL));
        assertFalse(Classifier.isDate(BYTE));
        assertFalse(Classifier.isDate(SHORT));
        assertFalse(Classifier.isDate(CHAR));
        assertFalse(Classifier.isDate(STRING));
        assertTrue(Classifier.isDate(DATE));
    }

    @Test
    public void isNumber(){
        assertTrue(Classifier.isNumber(INT));
        assertTrue(Classifier.isNumber(LONG));
        assertTrue(Classifier.isNumber(DOUBLE));
        assertTrue(Classifier.isNumber(FLOAT));
        assertTrue(Classifier.isNumber(SHORT));
        assertTrue(Classifier.isNumber(BYTE));
        assertFalse(Classifier.isNumber(BOOL));
        assertFalse(Classifier.isNumber(CHAR));
        assertFalse(Classifier.isNumber(STRING));
        assertFalse(Classifier.isNumber(DATE));
    }

    @Test
    public void isString(){
        assertFalse(Classifier.isString(INT));
        assertFalse(Classifier.isString(LONG));
        assertFalse(Classifier.isString(DOUBLE));
        assertFalse(Classifier.isString(FLOAT));
        assertFalse(Classifier.isString(BOOL));
        assertFalse(Classifier.isString(BYTE));
        assertFalse(Classifier.isString(SHORT));
        assertFalse(Classifier.isString(CHAR));
        assertTrue(Classifier.isString(STRING));
        assertFalse(Classifier.isString(DATE));
    }
}
