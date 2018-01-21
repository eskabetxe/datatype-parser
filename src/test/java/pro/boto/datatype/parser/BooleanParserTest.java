package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooleanParserTest {

    @Test
    public void whenNullValue() {
        assertThat(null, false, null);
    }

    @Test
    public void whenNotValidValue() {
        assertThat(this, false, null);
    }

    @Test
    public void whenBooleanValue() {
        assertThat(false, false, false);
        assertThat(true, true, true);
    }

    @Test
    public void whenIntegerValue() {
        assertThat(0, false, false);
        assertThat(1, true, true);
        assertThat(2, true, true);
    }

    @Test
    public void whenDoubleValue() {
        assertThat(0D, false, false);
        assertThat(0.4D, false, false);
        assertThat(1D, true, true);
        assertThat(2D, true, true);
    }

    @Test
    public void whenStringValue() {
        assertThat("", false, null);
        assertThat("dog", false, null);
        assertThat("yes", true, true);
        assertThat("t", true, true);
        assertThat("no", false, false);
        assertThat("off", false, false);
    }


    private void assertThat(Object value, boolean primitive, Boolean wrapper) {
        assertEquals(primitive, BooleanParser.toPrimitive(value), "primitive not expected");
        assertEquals(wrapper, BooleanParser.toBoolean(value), "wrapper not expected");
    }

}
