package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongParserTest {

    private Long LONG_0 = new Long(0);
    private Long LONG_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, LONG_0, LONG_NULL);
        assertThat(this, LONG_0, LONG_NULL);
    }

    @Test
    public void whenValue0ThenLong0() {
        Long result = new Long(0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenLongMinus10() {
        Long result = new Long(-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenLong10() {
        Long result = new Long(10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Long(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Long(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, new Long(Short.MIN_VALUE));
        assertThat(Short.MAX_VALUE, new Long(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, new Long(Integer.MIN_VALUE));
        assertThat(Integer.MAX_VALUE, new Long(Integer.MAX_VALUE));
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE, new Long(Long.MIN_VALUE));
        assertThat(Long.MAX_VALUE, new Long(Long.MAX_VALUE));
    }

    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, LONG_0, LONG_NULL);
        assertThat(Float.MAX_VALUE, LONG_0, LONG_NULL);
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, LONG_0, LONG_NULL);
        assertThat(Double.MAX_VALUE, LONG_0, LONG_NULL);
    }

    private void assertThat(Object value, Long values) {
        assertThat(value,values.longValue(),values);
    }
    private void assertThat(Object value, long primitive, Long wrapper) {
        assertEquals(primitive, LongParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, LongParser.toLong(value), "wrapper not expected");
    }


}
