package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, (byte)0, (Byte)null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, (byte)0, (Byte)null);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, Byte.MIN_VALUE, new Byte(Byte.MIN_VALUE));
        assertThat((byte)0, (byte)0, new Byte((byte)0));
        assertThat(Byte.MAX_VALUE, Byte.MAX_VALUE, new Byte(Byte.MAX_VALUE));
    }

    private void assertThat(Object value, byte primitive, Byte wrapper) {
        assertEquals("primitive not expected", primitive, ByteParser.toPrimitive(value));
        assertEquals("wrapper not expected", wrapper, ByteParser.toByte(value));
    }


}
