package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigIntegerParserTest {

    @Test
    public void whenBigInteger() {
        BigInteger result = BigInteger.valueOf(10);

        assertEquals(result, BigIntegerParser.toBigInteger(new Byte((byte)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new Short((short)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new Integer((int)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new Long((long)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new Float((float)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new Double((double)10)));
        assertEquals(result, BigIntegerParser.toBigInteger(new AtomicInteger(10)));
    }

    @Test
    public void whenInvalidBigInteger() {
        assertEquals(null, BigIntegerParser.toBigInteger(null));
        assertEquals(null, BigIntegerParser.toBigInteger("value"));
    }

}
