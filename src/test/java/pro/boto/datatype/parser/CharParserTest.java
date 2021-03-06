package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(primitive, CharParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, CharParser.toChar(value), "wrapper not expected");
    }


}
