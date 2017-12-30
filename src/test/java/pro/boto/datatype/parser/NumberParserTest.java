package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
public class NumberParserTest {

    @Test
    public void whenByteValue() {
        assertEquals((Byte)Byte.MIN_VALUE, NumberParser.toByte(Byte.MIN_VALUE));
        assertEquals((Byte)Byte.MAX_VALUE, NumberParser.toByte(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertEquals((Short)Short.MIN_VALUE, NumberParser.toShort(Short.MIN_VALUE));
        assertEquals((Short)Short.MAX_VALUE, NumberParser.toShort(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertEquals((Integer)Integer.MIN_VALUE, NumberParser.toInteger(Integer.MIN_VALUE));
        assertEquals((Integer)Integer.MAX_VALUE, NumberParser.toInteger(Integer.MAX_VALUE));
    }

    @Test
    public void whenLongValue() {
        assertEquals((Long)Long.MIN_VALUE, NumberParser.toLong(Long.MIN_VALUE));
        assertEquals((Long)Long.MIN_VALUE, NumberParser.toLong(Long.MIN_VALUE));
    }
    @Test
    public void whenFloatValue() {
        assertEquals((Float)(-Float.MAX_VALUE), NumberParser.toFloat(-Float.MAX_VALUE));
        assertEquals((Float)Float.MAX_VALUE, NumberParser.toFloat(Float.MAX_VALUE));
    }

    @Test
    public void whenDoubleValue() {
        assertEquals((Double)(-Double.MAX_VALUE), NumberParser.toDouble(-Double.MAX_VALUE));
        assertEquals((Double)Double.MAX_VALUE, NumberParser.toDouble(Double.MAX_VALUE));
    }

    @Test
    public void whenBigDecimal() {
        BigDecimal result = BigDecimal.valueOf(10);
        assertEquals(result, NumberParser.toBigDecimal(new Byte((byte)10)));
        assertEquals(result, NumberParser.toBigDecimal(new Short((short)10)));
        assertEquals(result, NumberParser.toBigDecimal(new Integer((int)10)));
        assertEquals(result, NumberParser.toBigDecimal(new Long((long)10)));
        assertEquals(result, NumberParser.toBigDecimal(BigInteger.valueOf(10)));
        result = BigDecimal.valueOf(10D);
        assertEquals(result, NumberParser.toBigDecimal(new Float((float)10)));
        assertEquals(result, NumberParser.toBigDecimal(new Double((double)10)));
    }

    @Test
    public void whenInvalidBigDecimal() {
        assertEquals(null, NumberParser.toBigDecimal(null));
        assertEquals(null, NumberParser.toBigDecimal("value"));
    }

    @Test
    public void whenBigInteger() {
        BigInteger result = BigInteger.valueOf(10);

        assertEquals(result, NumberParser.toBigInteger(new Byte((byte)10)));
        assertEquals(result, NumberParser.toBigInteger(new Short((short)10)));
        assertEquals(result, NumberParser.toBigInteger(new Integer((int)10)));
        assertEquals(result, NumberParser.toBigInteger(new Long((long)10)));
        assertEquals(result, NumberParser.toBigInteger(new Float((float)10)));
        assertEquals(result, NumberParser.toBigInteger(new Double((double)10)));
    }

    @Test
    public void whenInvalidBigInteger() {
        assertEquals(null, NumberParser.toBigInteger(null));
        assertEquals(null, NumberParser.toBigInteger("value"));
    }

    @Test
    public void whenNotValidNumber() {
        assertEquals(BigDecimal.valueOf(100D),NumberParser.toBigDecimal(new AtomicInteger(100)));
    }

    @Test
    public void testIsInByteRange() {
        assertTrue(NumberParser.isInByteRange(0));
        assertTrue(NumberParser.isInByteRange(Byte.MIN_VALUE));
        assertTrue(NumberParser.isInByteRange(Byte.MAX_VALUE));
        assertFalse(NumberParser.isInByteRange(128));
        assertFalse(NumberParser.isInByteRange(-129));
        assertTrue(NumberParser.isInByteRange(126.55));
        assertTrue(NumberParser.isInByteRange(126.56));
        assertTrue(NumberParser.isInByteRange(127.01));
        assertTrue(NumberParser.isInByteRange(127.46));

        assertTrue(NumberParser.isInByteRange(127.49));
        assertFalse(NumberParser.isInByteRange(127.50));
        assertFalse(NumberParser.isInByteRange(127.51));
        assertFalse(NumberParser.isInByteRange(128.55));
        assertFalse(NumberParser.isInByteRange(Float.NaN));
        assertFalse(NumberParser.isInByteRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInShortRange() {
        assertTrue(NumberParser.isInShortRange(0));
        assertTrue(NumberParser.isInShortRange(-32768));
        assertTrue(NumberParser.isInShortRange(32767));
        assertFalse(NumberParser.isInShortRange(32768));
        assertFalse(NumberParser.isInShortRange(-32769));
        assertFalse(NumberParser.isInShortRange(32767.55));
        assertFalse(NumberParser.isInShortRange(32768.88));
        assertFalse(NumberParser.isInShortRange(Float.NaN));
        assertFalse(NumberParser.isInShortRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInIntegerRange() {
        assertTrue(NumberParser.isInIntegerRange(0));
        assertTrue(NumberParser.isInIntegerRange(Integer.MIN_VALUE));
        assertTrue(NumberParser.isInIntegerRange(Integer.MAX_VALUE));
        assertFalse(NumberParser.isInIntegerRange((long)Integer.MAX_VALUE+1));
        assertFalse(NumberParser.isInIntegerRange((long)Integer.MIN_VALUE-1));
        assertTrue(NumberParser.isInIntegerRange((double)Integer.MAX_VALUE+0.45));
        assertFalse(NumberParser.isInIntegerRange((double)Integer.MAX_VALUE+0.55));
        assertFalse(NumberParser.isInIntegerRange(Float.NaN));
        assertFalse(NumberParser.isInIntegerRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testIsInLongRange() {
        assertTrue(NumberParser.isInLongRange(0));
        assertTrue(NumberParser.isInLongRange(Long.MIN_VALUE));
        assertTrue(NumberParser.isInLongRange(Long.MAX_VALUE));
        assertFalse(NumberParser.isInLongRange(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(1))));
        assertFalse(NumberParser.isInLongRange(BigInteger.valueOf(Long.MIN_VALUE).add(BigInteger.valueOf(-1))));
        assertFalse(NumberParser.isInLongRange(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.valueOf(0.55))));
        assertFalse(NumberParser.isInLongRange(Float.NaN));
        assertFalse(NumberParser.isInLongRange(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testBadRequest() {
        assertFalse(NumberParser.isInRange(Float.POSITIVE_INFINITY, BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE)));
        assertFalse(NumberParser.isInRange(Float.POSITIVE_INFINITY, BigDecimal.valueOf(-Float.MAX_VALUE), BigDecimal.valueOf(Float.MAX_VALUE)));
    }

}
