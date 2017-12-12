package pro.boto.datatype.validators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static pro.boto.datatype.classifiers.Classifier.*;

public class NumberUtils {

    public static BigInteger getBigInteger(Number number) {
        return getBigInteger(number, RoundingMode.HALF_EVEN);
    }

    public static BigInteger getBigInteger(Number number, RoundingMode mode) {
        if (isBigInteger(number)) return (BigInteger) number;
        return getBigDecimal(number)
                .setScale(0, mode)
                .toBigInteger();
    }

    public static BigDecimal getBigDecimal(Number number) {
        if(!isNumber(number)) return null;
        BigDecimal value = null;
        if (isBigDecimal(number)) value = (BigDecimal) number;
        if (isBigInteger(number)) value = new BigDecimal((BigInteger) number);
        if (isComplementInteger(number)) value = new BigDecimal(number.longValue());
        if (isFloatingPoint(number)) value = new BigDecimal(number.doubleValue());

        if (isNull(value)) {
            // not a standard number
            value = new BigDecimal(number.doubleValue());
        }
        return value;
    }

    protected static boolean isComplementInteger(Number number) {
        return isByte(number) || isShort(number) || isInteger(number) || isLong(number);
    }

    protected static boolean isFloatingPoint(Number number) {
        return isFloat(number) || isDouble(number);
    }
}
