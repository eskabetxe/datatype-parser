package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, 0, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, 0, null);
    }

    @Test
    public void whenIntegerValue() {
        assertThat(Integer.MIN_VALUE, Integer.MIN_VALUE, new Integer(Integer.MIN_VALUE));
        assertThat(0, 0, new Integer(0));
        assertThat(Integer.MAX_VALUE, Integer.MAX_VALUE, new Integer(Integer.MAX_VALUE));
    }

    @Test
    public void whenDoubleValue() {
        Double value = Double.MIN_VALUE;
        assertThat(value, value.intValue(), value.intValue());
        value = Double.MAX_VALUE;
        assertThat(value, value.intValue(), value.intValue());
        for (int i=0; i<10; i++){
            assertThat(new Double(i), i, new Integer(i));
        }
    }

    @Test
    public void whenDoubleDecimalValue() {
        for (int i=0; i<10; i++){
            assertThat(new Double(1+(i/10)), 1, 1);
        }
    }

    private void assertThat(Object value, int primitive, Integer wrapper) {
        assertEquals("primitive not expected", primitive, IntegerParser.toPrimitive(value));
        assertEquals("wrapper not expected", wrapper, IntegerParser.toInteger(value));
    }


}
