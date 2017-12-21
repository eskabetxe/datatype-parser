package pro.boto.datatype.parser;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static pro.boto.datatype.classifiers.Classifier.*;

public class NumberParser {

    private static final BigInteger BYTE_MIN = BigInteger.valueOf(Byte.MIN_VALUE);
    private static final BigInteger BYTE_MAX = BigInteger.valueOf(Byte.MAX_VALUE);
    private static final BigInteger SHORT_MIN = BigInteger.valueOf(Short.MIN_VALUE);
    private static final BigInteger SHORT_MAX = BigInteger.valueOf(Short.MAX_VALUE);
    private static final BigInteger INTEGER_MIN = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);

    private static final BigDecimal FLOAT_MAX = BigDecimal.valueOf(Float.MAX_VALUE);
    private static final BigDecimal FLOAT_MIN = BigDecimal.valueOf(-Float.MAX_VALUE);
    private static final BigDecimal DOUBLE_MAX = BigDecimal.valueOf(Double.MAX_VALUE);
    private static final BigDecimal DOUBLE_MIN = BigDecimal.valueOf(-Double.MAX_VALUE);

    private NumberParser() {}

    public static Byte toByte(Object value) {
        return ByteParser.toByte(value);
    }

    public static Short toShort(Object value) {
        return ShortParser.toShort(value);
    }

    public static Integer toInteger(Object value) {
        return IntegerParser.toInteger(value);
    }

    public static Long toLong(Object value) {
        return LongParser.toLong(value);
    }

    public static Float toFloat(Object value) {
        return FloatParser.toFloat(value);
    }

    public static Double toDouble(Object value) {
        return DoubleParser.toDouble(value);
    }


    public static boolean isComplementInteger(Object number) {
        return isByte(number) || isShort(number) || isInteger(number) || isLong(number);
    }

    public static boolean isFloatingPoint(Object number) {
        return isFloat(number) || isDouble(number);
    }

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

    protected static boolean isInRange(Number number, BigInteger min, BigInteger max) {
        try {
            BigInteger bigInteger = toBigInteger(number);
            return max.compareTo(bigInteger) >= 0 && min.compareTo(bigInteger) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected static boolean isInRange(Number number, BigDecimal min, BigDecimal max) {
        try {
            BigDecimal bigDecimal = toBigDecimal(number);
            return max.compareTo(bigDecimal) >= 0 && min.compareTo(bigDecimal) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static BigInteger toBigInteger(Object value) {
        return toBigInteger(value, RoundingMode.HALF_EVEN);
    }

    public static BigInteger toBigInteger(Object value, RoundingMode mode) {
        if(isNull(value) || !isNumber(value)) {
            return null;
        }

        if (isBigInteger(value)) return (BigInteger) value;
        return toBigDecimal(value)
                .setScale(0, mode)
                .toBigInteger();
    }

    public static BigDecimal toBigDecimal(Object value) {
        if(isNull(value) || !isNumber(value)) {
            return null;
        }

        BigDecimal number;
        if (isBigDecimal(value)) {
            number = (BigDecimal)value;
        }if (isBigInteger(value)) {
            number = new BigDecimal((BigInteger) value);
        } if (isComplementInteger(value)) {
            number = new BigDecimal(((Number)value).longValue());
        } else if (isFloatingPoint(value)) {
            number = new BigDecimal(((Number)value).doubleValue());
        } else {
            // not a standard number
            number = new BigDecimal(((Number)value).doubleValue());
        }
        return number;
    }

}
