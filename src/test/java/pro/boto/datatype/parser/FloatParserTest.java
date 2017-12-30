package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class FloatParserTest {

    private Float FLOAT_0 = new Float(0);
    private Float FLOAT_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, FLOAT_0, FLOAT_NULL);
        assertThat(this, FLOAT_0, FLOAT_NULL);
    }

    @Test
    public void whenValue0ThenFloat0() {
        Float result = new Float(0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenFloatMinus10() {
        Float result = new Float(-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenFloat10() {
        Float result = new Float(10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Float(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Float(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, new Float(Short.MIN_VALUE));
        assertThat(Short.MAX_VALUE, new Float(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, new Float(Integer.MIN_VALUE));
        assertThat(Integer.MAX_VALUE, new Float(Integer.MAX_VALUE));
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE, new Float(Long.MIN_VALUE));
        assertThat(Long.MAX_VALUE, new Float(Long.MAX_VALUE));
    }

    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, new Float(-Float.MAX_VALUE));
        assertThat(Float.MAX_VALUE, new Float(Float.MAX_VALUE));
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, FLOAT_0, FLOAT_NULL);
        assertThat(Double.MAX_VALUE, FLOAT_0, FLOAT_NULL);
    }

    private void assertThat(Object value, Float values) {
        assertThat(value, values.floatValue(), values);
    }
    private void assertThat(Object value, float primitive, Float wrapper) {
        assertEquals(primitive, FloatParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, FloatParser.toFloat(value), "wrapper not expected");
    }


}
