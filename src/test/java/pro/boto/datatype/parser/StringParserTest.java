package pro.boto.datatype.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringParserTest {

    @Test
    public void whenNotValidValue() {
        assertThat(null, null);
        assertThat(this,  null);
    }

    @Test
    public void whenStringValue() {
        assertThat("abc",  "abc");
        assertThat(100,  "100");
        assertThat(110.55,  "110.55");
        assertThat(110.555,  "110.555");
    }


    private void assertThat(Object value, String wrapper) {
        assertEquals("string not expected", wrapper, StringParser.toString(value));
    }


}
