package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, 0D, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, 0D, null);
    }

    @Test
    public void whenDoubleValue() {
        for (int i=0; i<10; i++){
            Double value = new Double(i);
            assertThat(value.doubleValue(), value.doubleValue(), value);
            assertThat(value, value.doubleValue(), value);
        }
    }

    @Test
    public void whenDoubleDecimalValue() {
        for (int i=0; i<10; i++){
            Double value = new Double(1+(i/10));
            assertThat(value.doubleValue(), value.doubleValue(), value);
            assertThat(value, value.doubleValue(), value);
        }
    }

    private void assertThat(Object value, double primitive, Double wrapper) {
        assertEquals("primitive not expected", primitive, DoubleParser.toPrimitive(value), 0);
        assertEquals("wrapper not expected", wrapper, DoubleParser.toDouble(value));
    }


}
