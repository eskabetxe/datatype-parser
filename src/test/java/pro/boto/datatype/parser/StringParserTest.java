package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
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
        assertEquals(wrapper, StringParser.toString(value));
    }


}
