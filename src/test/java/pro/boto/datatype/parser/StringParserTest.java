package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this,  null);
    }

    @Test
    public void whenStringValue() {
        assertThat("abc",  "abc");
    }


    private void assertThat(Object value, String wrapper) {
        assertEquals("string not expected", wrapper, StringParser.toString(value));
    }


}
