package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, 0F, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, 0F, null);
    }

    @Test
    public void whenFloatValue() {
        for (int i=0; i<10; i++){
            Float value = new Float(i);
            assertThat(value.floatValue(), value.floatValue(), value);
            assertThat(value, value.floatValue(), value);
        }
    }

    @Test
    public void whenFloatDecimalValue() {
        for (int i=0; i<10; i++){
            Float value = new Float(1+(i/10));
            assertThat(value.floatValue(), value.floatValue(), value);
            assertThat(value, value.floatValue(), value);
        }
    }

    private void assertThat(Object value, float primitive, Float wrapper) {
        assertEquals("primitive not expected", primitive, FloatParser.toPrimitive(value), 0);
        assertEquals("wrapper not expected", wrapper, FloatParser.toFloat(value));
    }


}
