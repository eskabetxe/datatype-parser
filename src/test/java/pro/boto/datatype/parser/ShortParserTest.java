package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, (short)0, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, (short)0, null);
    }

    @Test
    public void whenShortValue() {
        for (int i=0; i<10; i++){
            Short value = new Short((short)i);
            assertThat(value.shortValue(), value.shortValue(), value);
            assertThat(value, value.shortValue(), value);
        }
    }

    private void assertThat(Object value, short primitive, Short wrapper) {
        assertEquals("primitive not expected", primitive, ShortParser.toPrimitive(value), 0);
        assertEquals("wrapper not expected", wrapper, ShortParser.toShort(value));
    }


}
