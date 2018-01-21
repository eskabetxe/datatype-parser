package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateParserTest {

    @Test
    public void whenNotValidValue() {
        assertThat(null, null);
        assertThat(this, null);
    }

    @Test
    public void whenDateValue() {
        Date value  = new Date();
        assertThat(value, value);
    }

    @Test
    public void whenLongValue() {
        Long value  = new Date().getTime();
        assertThat(value, new Date(value));
    }

    private void assertThat(Object value, Date wrapper) {
        assertEquals(wrapper, DateParser.toDate(value), "wrapper not expected");
    }


}
