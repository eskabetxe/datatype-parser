package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.isInLongRange;
import static pro.boto.datatype.parser.NumberParser.toBigInteger;

public class LongParser {

    private final static long DEFAULT_VALUE = 0L;

    private LongParser() {}

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toLong(value), DEFAULT_VALUE);
    }

    public static Long toLong(Object value) {
        if (isNull(value) || isLong(value)) {
            return (Long) value;
        }

        Long converted = null;
        if (isNumber(value) && isInLongRange((Number)value)) {
            converted = toBigInteger(value).longValueExact();
        }

        return converted;
    }
}
