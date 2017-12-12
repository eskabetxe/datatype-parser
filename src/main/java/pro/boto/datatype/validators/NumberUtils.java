package pro.boto.datatype.validators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static pro.boto.datatype.classifiers.Classifier.*;

public class NumberUtils {
    //https://github.com/cchabanois/transmorph/blob/master/src/main/java/net/entropysoft/transmorph/utils/NumberUtils.java

    protected static boolean isComplementInteger(Number number) {
        return isByte(number) || isShort(number) || isInteger(number) || isLong(number);
    }

    protected static boolean isFloatingPoint(Number number) {
        return isFloat(number) || isDouble(number);
    }

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
        if (isBigDecimal(number)) return (BigDecimal) number;
        if (isBigInteger(number)) return new BigDecimal((BigInteger) number);
        if (isComplementInteger(number)) return new BigDecimal(number.longValue());
        if (isFloatingPoint(number)) return new BigDecimal(number.doubleValue());
        // not a standard number
        return new BigDecimal(number.doubleValue());
    }
}
