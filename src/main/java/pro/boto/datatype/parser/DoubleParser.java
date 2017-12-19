package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.validators.NumberUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.validators.NumberInRange.isInDoubleRange;

public class DoubleParser {

    private final static double DEFAULT_VALUE = 0D;

    private DoubleParser() {}

    public static double toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toDouble(value), DEFAULT_VALUE);
    }

    public static Double toDouble(Object value) {
        if (isNull(value)) return null;
        if (isDouble(value)) return (Double) value;
        if (isNumber(value) && isInDoubleRange((Number)value))
            return NumberUtils.getBigDecimal((Number)value).doubleValue();

        return null;
    }
}
