package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, (char)0, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, (char)0, null);
    }

    @Test
    public void whenCharValue() {
        assertThat('a', 'a', new Character('a'));
    }

    private void assertThat(Object value, char primitive, Character wrapper) {
        assertEquals("primitive not expected", primitive, CharParser.toPrimitive(value));
        assertEquals("wrapper not expected", wrapper, CharParser.toChar(value));
    }


}
