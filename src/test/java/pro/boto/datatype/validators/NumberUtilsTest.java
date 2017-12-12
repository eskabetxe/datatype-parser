package pro.boto.datatype.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

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
    }

    @Test
    public void whenNotValidNumber() {
        assertEquals(new BigDecimal(100),NumberUtils.getBigDecimal(new AtomicInteger(100)));
    }

  /*  @Test
    public void testCommonNumberClass() {
        assertEquals(Byte.class, NumberUtils.getCommonNumberClass(Byte.class,
                Byte.class));
        assertEquals(Long.class, NumberUtils.getCommonNumberClass(Byte.class,
                Long.class));
        assertEquals(Long.class, NumberUtils.getCommonNumberClass(Long.class,
                Byte.class));
        assertEquals(BigInteger.class, NumberUtils.getCommonNumberClass(Byte.class,
                BigInteger.class));
        assertEquals(Double.class, NumberUtils.getCommonNumberClass(Double.class,
                Double.class));
        assertEquals(Double.class, NumberUtils.getCommonNumberClass(Float.class,
                Double.class));
        assertEquals(Double.class, NumberUtils.getCommonNumberClass(Double.class,
                Float.class));
        assertEquals(BigDecimal.class, NumberUtils.getCommonNumberClass(Double.class,
                Byte.class));
        assertEquals(BigDecimal.class, NumberUtils.getCommonNumberClass(BigInteger.class,
                Float.class));
        assertEquals(BigDecimal.class, NumberUtils.getCommonNumberClass(BigInteger.class,
                BigDecimal.class));
    }
    */

}
