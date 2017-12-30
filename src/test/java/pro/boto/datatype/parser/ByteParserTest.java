package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class ByteParserTest {

    private Byte BYTE_0 = new Byte((byte)0);
    private Byte BYTE_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, BYTE_0, BYTE_NULL);
        assertThat(this, BYTE_0, BYTE_NULL);
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
        assertThat(Short.MIN_VALUE, BYTE_0, BYTE_NULL);
        assertThat(Short.MAX_VALUE, BYTE_0, BYTE_NULL);
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, BYTE_0, BYTE_NULL);
        assertThat(Integer.MAX_VALUE, BYTE_0, BYTE_NULL);
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE, BYTE_0, BYTE_NULL);
        assertThat(Long.MAX_VALUE, BYTE_0, BYTE_NULL);
    }

    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, BYTE_0, BYTE_NULL);
        assertThat(Float.MAX_VALUE, BYTE_0, BYTE_NULL);
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, BYTE_0, BYTE_NULL);
        assertThat(Double.MAX_VALUE, BYTE_0, BYTE_NULL);
    }

    private void assertThat(Object value, Byte values) {
        assertThat(value,values.byteValue(),values);
    }

    private void assertThat(Object value, byte primitive, Byte wrapper) {
        assertEquals(primitive, ByteParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, ByteParser.toByte(value), "wrapper not expected");
    }


}
