package pro.boto.datatype.parser;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.classifiers.NumberClassifier.isComplementInteger;
import static pro.boto.datatype.classifiers.NumberClassifier.isFloatingPoint;

public final class BigIntegerParser {

    private BigIntegerParser() { }

    public static BigInteger toBigInteger(Object value) {
        return toBigInteger(value, RoundingMode.HALF_EVEN);
    }

    public static BigInteger toBigInteger(Object value, RoundingMode mode) {
        if (isNull(value) || isBigInteger(value)) {
            return (BigInteger) value;
        }

        BigInteger converted = null;
        if (isComplementInteger(value)) {
            converted = BigInteger.valueOf(((Number)value).longValue());
        } else if (isFloatingPoint(value)) {
            converted = round(BigDecimal.valueOf(((Number)value).doubleValue()), mode);
        } else if (isBigDecimal(value)) {
            converted = round(((BigDecimal)value), mode);
        } else if (isNumber(value)){
            // not a standard number
            converted = round(BigDecimal.valueOf(((Number)value).doubleValue()), mode);
        }

        return converted;
    }

    private static BigInteger round(BigDecimal value, RoundingMode mode) {
        return value.setScale(0, mode).toBigInteger();
    }
}
