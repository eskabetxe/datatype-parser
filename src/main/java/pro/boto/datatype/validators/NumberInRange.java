package pro.boto.datatype.validators;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Check if number are in a given range
 *
 * @author Cedric Chabanois (cchabanois at gmail.com)
 *
 */
public class NumberInRange {

    public static final BigInteger BYTE_MIN = BigInteger.valueOf(Byte.MIN_VALUE);
    public static final BigInteger BYTE_MAX = BigInteger.valueOf(Byte.MAX_VALUE);
    public static final BigInteger SHORT_MIN = BigInteger.valueOf(Short.MIN_VALUE);
    public static final BigInteger SHORT_MAX = BigInteger.valueOf(Short.MAX_VALUE);
    public static final BigInteger INTEGER_MIN = BigInteger.valueOf(Integer.MIN_VALUE);
    public static final BigInteger INTEGER_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
    public static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    public static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);

    public static final BigDecimal FLOAT_MAX = BigDecimal.valueOf(Float.MAX_VALUE);
    public static final BigDecimal FLOAT_MIN = BigDecimal.valueOf(-Float.MAX_VALUE);
    public static final BigDecimal DOUBLE_MAX = BigDecimal.valueOf(Double.MAX_VALUE);
    public static final BigDecimal DOUBLE_MIN = BigDecimal.valueOf(-Double.MAX_VALUE);

    public static boolean isInByteRange(Number number) {
        return isInRange(number, BYTE_MIN, BYTE_MAX);
    }

    public static boolean isInShortRange(Number number) {
        return isInRange(number, SHORT_MIN, SHORT_MAX);
    }

    public static boolean isInIntegerRange(Number number) {
        return isInRange(number, INTEGER_MIN, INTEGER_MAX);
    }

    public static boolean isInLongRange(Number number) {
        return isInRange(number, LONG_MIN, LONG_MAX);
    }

    public static boolean isInFloatRange(Number number) {
        return isInRange(number, FLOAT_MIN, FLOAT_MAX);
    }

    public static boolean isInDoubleRange(Number number) {
        return isInRange(number, DOUBLE_MIN, DOUBLE_MAX);
    }

    public static boolean isInRange(Number number, BigInteger min, BigInteger max) {
        try {
            BigInteger bigInteger = NumberUtils.getBigInteger(number);
            return max.compareTo(bigInteger) >= 0
                    && min.compareTo(bigInteger) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(Number number, BigDecimal min, BigDecimal max) {
        try {
            BigDecimal bigDecimal = NumberUtils.getBigDecimal(number);
            return max.compareTo(bigDecimal) >= 0
                    && min.compareTo(bigDecimal) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
