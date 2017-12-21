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
        if (isNull(value)) return null;
        if (isLong(value)) return (Long) value;
        if (isNumber(value) && isInLongRange((Number)value))
            return toBigInteger(value).longValueExact();

        return null;
    }
}
