package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class DoubleParserTest {

    private Double DOUBLE_0 = new Double(0);
    private Double DOUBLE_NULL = null;

    @Test
    public void whenNotValidValue() {
        assertThat(null, DOUBLE_0, DOUBLE_NULL);
        assertThat(this, DOUBLE_0, DOUBLE_NULL);
        assertThat(BigDecimal.valueOf(Double.MAX_VALUE)
                             .add(BigDecimal.valueOf(1D)), DOUBLE_0, DOUBLE_NULL);
    }

    @Test
    public void whenValue0ThenFloat0() {
        Double result = new Double(0);

        assertThat(new Byte((byte)0), result);
        assertThat(new Short((short)0), result);
        assertThat(new Integer((int)0), result);
        assertThat(new Long((long)0), result);
        assertThat(new Float((float)0), result);
        assertThat(new Double((double)0), result);
    }

    @Test
    public void whenValueMinus10ThenDoubleMinus10() {
        Double result = new Double(-10);

        assertThat(new Byte((byte)-10), result);
        assertThat(new Short((short)-10), result);
        assertThat(new Integer((int)-10), result);
        assertThat(new Long((long)-10), result);
        assertThat(new Float((float)-10), result);
        assertThat(new Double((double)-10), result);
    }

    @Test
    public void whenValue10ThenDouble10() {
        Double result = new Double(10);

        assertThat(new Byte((byte)10), result);
        assertThat(new Short((short)10), result);
        assertThat(new Integer((int)10), result);
        assertThat(new Long((long)10), result);
        assertThat(new Float((float)10), result);
        assertThat(new Double((double)10), result);
    }

    @Test
    public void whenByteValue() {
        assertThat(Byte.MIN_VALUE, new Double(Byte.MIN_VALUE));
        assertThat(Byte.MAX_VALUE, new Double(Byte.MAX_VALUE));
    }

    @Test
    public void whenShortValue() {
        assertThat(Short.MIN_VALUE, new Double(Short.MIN_VALUE));
        assertThat(Short.MAX_VALUE, new Double(Short.MAX_VALUE));
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, new Double(Integer.MIN_VALUE));
        assertThat(Integer.MAX_VALUE, new Double(Integer.MAX_VALUE));
    }

    @Test
    public void whenLongValue() {
        assertThat(Long.MIN_VALUE ,new Double(Long.MIN_VALUE));
        assertThat(Long.MAX_VALUE, new Double(Long.MAX_VALUE));
    }

    @Test
    public void whenFloatValue() {
        assertThat(-Float.MAX_VALUE, new Double(-Float.MAX_VALUE));
        assertThat(Float.MAX_VALUE, new Double(Float.MAX_VALUE));
    }

    @Test
    public void whenDoubleValue() {
        assertThat(-Double.MAX_VALUE, new Double(-Double.MAX_VALUE));
        assertThat(Double.MAX_VALUE, new Double(Double.MAX_VALUE));
    }

    private void assertThat(Object value, Double values) {
        assertThat(value, values.doubleValue(), values);
    }

    private void assertThat(Object value, double primitive, Double wrapper) {
        assertEquals(primitive, DoubleParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, DoubleParser.toDouble(value), "wrapper not expected");
    }


}
