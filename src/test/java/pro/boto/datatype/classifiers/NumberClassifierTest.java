package pro.boto.datatype.classifiers;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class NumberClassifierTest {

    @Test
    public void testIsInByteRange() {
        assertTrue(NumberClassifier.isInByteRange(0));
        assertTrue(NumberClassifier.isInByteRange(Byte.MIN_VALUE));
        assertTrue(NumberClassifier.isInByteRange(Byte.MAX_VALUE));
        assertFalse(NumberClassifier.isInByteRange(128));
        assertFalse(NumberClassifier.isInByteRange(-129));
        assertTrue(NumberClassifier.isInByteRange(126.55));
        assertTrue(NumberClassifier.isInByteRange(126.56));
        assertTrue(NumberClassifier.isInByteRange(127.01));
        assertTrue(NumberClassifier.isInByteRange(127.46));

        assertTrue(NumberClassifier.isInByteRange(127.49));
        assertFalse(NumberClassifier.isInByteRange(127.50));
        assertFalse(NumberClassifier.isInByteRange(127.51));
        assertFalse(NumberClassifier.isInByteRange(128.55));
        assertFalse(NumberClassifier.isInByteRange(Float.NaN));
        assertFalse(NumberClassifier.isInByteRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInShortRange() {
        assertTrue(NumberClassifier.isInShortRange(0));
        assertTrue(NumberClassifier.isInShortRange(-32768));
        assertTrue(NumberClassifier.isInShortRange(32767));
        assertFalse(NumberClassifier.isInShortRange(32768));
        assertFalse(NumberClassifier.isInShortRange(-32769));
        assertFalse(NumberClassifier.isInShortRange(32767.55));
        assertFalse(NumberClassifier.isInShortRange(32768.88));
        assertFalse(NumberClassifier.isInShortRange(Float.NaN));
        assertFalse(NumberClassifier.isInShortRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInIntegerRange() {
        assertTrue(NumberClassifier.isInIntegerRange(0));
        assertTrue(NumberClassifier.isInIntegerRange(Integer.MIN_VALUE));
        assertTrue(NumberClassifier.isInIntegerRange(Integer.MAX_VALUE));
        assertFalse(NumberClassifier.isInIntegerRange((long)Integer.MAX_VALUE+1));
        assertFalse(NumberClassifier.isInIntegerRange((long)Integer.MIN_VALUE-1));
        assertTrue(NumberClassifier.isInIntegerRange((double)Integer.MAX_VALUE+0.45));
        assertFalse(NumberClassifier.isInIntegerRange((double)Integer.MAX_VALUE+0.55));
        assertFalse(NumberClassifier.isInIntegerRange(Float.NaN));
        assertFalse(NumberClassifier.isInIntegerRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInLongRange() {
        assertTrue(NumberClassifier.isInLongRange(0));
        assertTrue(NumberClassifier.isInLongRange(Long.MIN_VALUE));
        assertTrue(NumberClassifier.isInLongRange(Long.MAX_VALUE));
        assertFalse(NumberClassifier.isInLongRange(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(1))));
        assertFalse(NumberClassifier.isInLongRange(BigInteger.valueOf(Long.MIN_VALUE).add(BigInteger.valueOf(-1))));
        assertFalse(NumberClassifier.isInLongRange(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.valueOf(0.55))));
    }

    @Test
    public void testIsInFloatRange() {
        assertTrue(NumberClassifier.isInFloatRange(0));
        assertTrue(NumberClassifier.isInFloatRange(Float.MIN_VALUE));
        assertTrue(NumberClassifier.isInFloatRange(Float.MAX_VALUE));
        assertFalse(NumberClassifier.isInFloatRange(BigDecimal.valueOf(Float.MAX_VALUE).add(BigDecimal.valueOf(1))));
        assertFalse(NumberClassifier.isInFloatRange(BigDecimal.valueOf(-Float.MAX_VALUE).add(BigDecimal.valueOf(-1))));
        assertFalse(NumberClassifier.isInFloatRange(BigDecimal.valueOf(Float.MAX_VALUE).add(BigDecimal.valueOf(0.55))));
        assertFalse(NumberClassifier.isInFloatRange(Float.NaN));
        assertFalse(NumberClassifier.isInFloatRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInDoubleRange() {
        assertTrue(NumberClassifier.isInDoubleRange(0));
        assertTrue(NumberClassifier.isInDoubleRange(Double.MIN_VALUE));
        assertTrue(NumberClassifier.isInDoubleRange(Double.MAX_VALUE));
        assertFalse(NumberClassifier.isInDoubleRange(BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(1))));
        assertFalse(NumberClassifier.isInDoubleRange(BigDecimal.valueOf(-Double.MAX_VALUE).add(BigDecimal.valueOf(-1))));
        assertFalse(NumberClassifier.isInDoubleRange(BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(0.55))));
        assertFalse(NumberClassifier.isInDoubleRange(Double.NaN));
        assertFalse(NumberClassifier.isInDoubleRange(Double.POSITIVE_INFINITY));
    }


    @Test
    public void testBadRequest() {
        assertFalse(NumberClassifier.isInRange(Float.POSITIVE_INFINITY, BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE)));
        assertFalse(NumberClassifier.isInRange(Float.POSITIVE_INFINITY, BigDecimal.valueOf(-Float.MAX_VALUE), BigDecimal.valueOf(Float.MAX_VALUE)));
        assertFalse(NumberClassifier.isInRange(Double.POSITIVE_INFINITY, BigDecimal.valueOf(-Double.MAX_VALUE), BigDecimal.valueOf(Double.MAX_VALUE)));
    }

}
