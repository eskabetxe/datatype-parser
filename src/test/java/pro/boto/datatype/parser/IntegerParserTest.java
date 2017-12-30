package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class IntegerParserTest {

    private Integer INTEGER_0 = new Integer(0);
    private Integer INTEGER_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, INTEGER_0, INTEGER_NULL);
        assertThat(this, INTEGER_0, INTEGER_NULL);
    }

    @Test
    public void whenValue0ThenInteger0() {
        Integer result = new Integer(0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenIntegerMinus10() {
        Integer result = new Integer(-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenInteger10() {
        Integer result = new Integer(10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Integer(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Integer(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, new Integer(Short.MIN_VALUE));
        assertThat(Short.MAX_VALUE, new Integer(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertThat(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE, INTEGER_0, INTEGER_NULL);
        assertThat(Long.MAX_VALUE, INTEGER_0, INTEGER_NULL);
    }
    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, INTEGER_0, INTEGER_NULL);
        assertThat(Float.MAX_VALUE, INTEGER_0, INTEGER_NULL);
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, INTEGER_0, INTEGER_NULL);
        assertThat(Double.MAX_VALUE, INTEGER_0, INTEGER_NULL);
    }

    private void assertThat(Object value, Integer values) {
        assertThat(value,values.intValue(),values);
    }
    private void assertThat(Object value, int primitive, Integer wrapper) {
        assertEquals(primitive, IntegerParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, IntegerParser.toInteger(value), "wrapper not expected");
    }


}
