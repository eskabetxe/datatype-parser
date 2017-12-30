package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class ShortParserTest {

    private Short SHORT_0 = new Short((short)0);
    private Short SHORT_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, SHORT_0, SHORT_NULL);
        assertThat(this, SHORT_0, SHORT_NULL);
    }

    @Test
    public void whenValue0ThenShort0() {
        Short result = new Short((short)0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenShortMinus10() {
        Short result = new Short((short)-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenShort10() {
        Short result = new Short((short)10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Short(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Short(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, new Short(Short.MIN_VALUE));
        assertThat(Short.MAX_VALUE, new Short(Short.MAX_VALUE));
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

    private void assertThat(Object value, Short values) {
        assertThat(value,values.shortValue(),values);
    }
    private void assertThat(Object value, short primitive, Short wrapper) {
        assertEquals(primitive, ShortParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, ShortParser.toShort(value), "wrapper not expected");
    }


}
