package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberParserTest {

    @Test
    public void whenByteValue() {
        assertEquals("value not expected", (Byte)Byte.MIN_VALUE, NumberParser.toByte(Byte.MIN_VALUE));
        assertEquals("value not expected", (Byte)Byte.MAX_VALUE, NumberParser.toByte(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertEquals("value not expected", (Short)Short.MIN_VALUE, NumberParser.toShort(Short.MIN_VALUE));
        assertEquals("value not expected", (Short)Short.MAX_VALUE, NumberParser.toShort(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertEquals("value not expected", (Integer)Integer.MIN_VALUE, NumberParser.toInteger(Integer.MIN_VALUE));
        assertEquals("value not expected", (Integer)Integer.MAX_VALUE, NumberParser.toInteger(Integer.MAX_VALUE));
    }

    @Test
    public void whenLongValue() {
        assertEquals("value not expected", (Long)Long.MIN_VALUE, NumberParser.toLong(Long.MIN_VALUE));
        assertEquals("value not expected", (Long)Long.MIN_VALUE, NumberParser.toLong(Long.MIN_VALUE));
    }
    @Test
    public void whenFloatValue() {
        assertEquals("value not expected", (Float)(-Float.MAX_VALUE), NumberParser.toFloat(-Float.MAX_VALUE), 0);
        assertEquals("value not expected", (Float)Float.MAX_VALUE, NumberParser.toFloat(Float.MAX_VALUE), 0);
    }

    @Test
    public void whenDoubleValue() {
        assertEquals("value not expected", (Double)(-Double.MAX_VALUE), NumberParser.toDouble(-Double.MAX_VALUE), 0);
        assertEquals("value not expected", (Double)Double.MAX_VALUE, NumberParser.toDouble(Double.MAX_VALUE), 0);
    }

}
