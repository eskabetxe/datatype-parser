package pro.boto.datatype.parser;

import java.math.BigDecimal;
import java.math.BigInteger;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.classifiers.NumberClassifier.isComplementInteger;
import static pro.boto.datatype.classifiers.NumberClassifier.isFloatingPoint;

public final class BigDecimalParser {

    private BigDecimalParser() {}

    public static BigDecimal toBigDecimal(Object value) {
        if(isNull(value) || isBigDecimal(value)) {
            return (BigDecimal)value;
        }

        BigDecimal number = null;
        if (isBigInteger(value)) {
            number = new BigDecimal((BigInteger) value);
        } else if (isComplementInteger(value)) {
            number = BigDecimal.valueOf(((Number)value).longValue());
        } else if (isFloatingPoint(value)) {
            number = BigDecimal.valueOf(((Number)value).doubleValue());
        } else if (isNumber(value)){
            // not a standard number
            number = BigDecimal.valueOf(((Number)value).doubleValue());
        }
        return number;
    }

}
