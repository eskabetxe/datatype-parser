package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.isInDoubleRange;
import static pro.boto.datatype.parser.NumberParser.toBigDecimal;

public class DoubleParser {

    private final static double DEFAULT_VALUE = 0D;

    private DoubleParser() {}

    public static double toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toDouble(value), DEFAULT_VALUE);
    }

    public static Double toDouble(Object value) {
        if (isNull(value) || isDouble(value)) {
            return (Double) value;
        }

        Double converted = null;
        if (isNumber(value) && isInDoubleRange((Number)value)) {
            converted = toBigDecimal(value).doubleValue();
        }

        return converted;
    }
}
