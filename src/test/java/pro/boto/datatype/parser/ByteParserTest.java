package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteParserTest {

    private Byte SHORT_0 = new Byte((byte)0);
    private Byte SHORT_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, SHORT_0, SHORT_NULL);
        assertThat(this, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenValue0ThenByte0() {
        Byte result = new Byte((byte)0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenByteMinus10() {
        Byte result = new Byte((byte)-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenByte10() {
        Byte result = new Byte((byte)10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Byte(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Byte(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, SHORT_0, SHORT_NULL);
        assertThat(Short.MAX_VALUE, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, SHORT_0, SHORT_NULL);
        assertThat(Integer.MAX_VALUE, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE, SHORT_0, SHORT_NULL);
        assertThat(Long.MAX_VALUE, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, SHORT_0, SHORT_NULL);
        assertThat(Float.MAX_VALUE, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, SHORT_0, SHORT_NULL);
        assertThat(Double.MAX_VALUE, SHORT_0, SHORT_NULL);
    }

    private void assertThat(Object value, Byte values) {
        assertThat(value,values.byteValue(),values);
    }

    private void assertThat(Object value, byte primitive, Byte wrapper) {
        assertEquals("primitive not expected", primitive, ByteParser.toPrimitive(value));
        assertEquals("wrapper not expected", wrapper, ByteParser.toByte(value));
    }


}
