package pro.boto.datatype.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringParserTest {

    //@Test
    public void constructor() throws Exception {
        final Constructor<?>[] constructors = StringParser.class.getDeclaredConstructors();
        Assertions.assertTrue(constructors.length == 1);
        Constructor<?> constructor = constructors[0];
        Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
        assertThrows(UnsupportedOperationException.class, () -> constructor.newInstance());
    }

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
        assertThat( "abc".getBytes(), "abc");
    }


    private void assertThat(Object value, String wrapper) {
        assertEquals(wrapper, StringParser.toString(value));
    }


}
