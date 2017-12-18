package pro.boto.datatype.validators;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class NumberUtilsTest {

    @Test
    public void whenBigDecimal() {
        BigDecimal result = new BigDecimal(10);

        assertEquals(result, NumberUtils.getBigDecimal(new Byte((byte)10)));
        assertEquals(result, NumberUtils.getBigDecimal(new Short((short)10)));
        assertEquals(result, NumberUtils.getBigDecimal(new Integer((int)10)));
        assertEquals(result, NumberUtils.getBigDecimal(new Long((long)10)));
        assertEquals(result, NumberUtils.getBigDecimal(new Float((float)10)));
        assertEquals(result, NumberUtils.getBigDecimal(new Double((double)10)));
        assertEquals(result, NumberUtils.getBigDecimal(BigInteger.valueOf(10)));
    }

    @Test
    public void whenBigInteger() {
        BigInteger result = BigInteger.valueOf(10);

        assertEquals(result, NumberUtils.getBigInteger(new Byte((byte)10)));
        assertEquals(result, NumberUtils.getBigInteger(new Short((short)10)));
        assertEquals(result, NumberUtils.getBigInteger(new Integer((int)10)));
        assertEquals(result, NumberUtils.getBigInteger(new Long((long)10)));
        assertEquals(result, NumberUtils.getBigInteger(new Float((float)10)));
        assertEquals(result, NumberUtils.getBigInteger(new Double((double)10)));
    }


    @Test
    public void whenNotValidNumber() {
        assertEquals(new BigDecimal(100),NumberUtils.getBigDecimal(new AtomicInteger(100)));
    }

}
