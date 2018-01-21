package pro.boto.datatype.parser;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalParserTest {

    @Test
    public void whenBigDecimal() {
        BigDecimal result = BigDecimal.valueOf(10);
        assertEquals(result, BigDecimalParser.toBigDecimal(new Byte((byte)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(new Short((short)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(new Integer((int)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(new Long((long)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(BigInteger.valueOf(10)));
        result = BigDecimal.valueOf(10D);
        assertEquals(result, BigDecimalParser.toBigDecimal(new Float((float)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(new Double((double)10)));
        assertEquals(result, BigDecimalParser.toBigDecimal(new AtomicInteger(10)));
    }

    @Test
    public void whenInvalidBigDecimal() {
        assertEquals(null, BigDecimalParser.toBigDecimal(null));
        assertEquals(null, BigDecimalParser.toBigDecimal("value"));
    }

}
