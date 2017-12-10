package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, 0L, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, 0L, null);
    }

    @Test
    public void whenLongValue() {
        for (int i=0; i<10; i++){
            Long value = new Long(i);
            assertThat(value.longValue(), value.longValue(), value);
            assertThat(value, value.longValue(), value);
        }
    }

    @Test
    public void whenLongDecimalValue() {
        for (int i=0; i<10; i++){
            Long value = new Long(1+(i/10));
            assertThat(value.longValue(), value.longValue(), value);
            assertThat(value, value.longValue(), value);
        }
    }

    private void assertThat(Object value, long primitive, Long wrapper) {
        assertEquals("primitive not expected", primitive, LongParser.toPrimitive(value), 0);
        assertEquals("wrapper not expected", wrapper, LongParser.toLong(value));
    }


}
