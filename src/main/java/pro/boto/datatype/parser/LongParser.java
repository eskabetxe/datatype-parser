package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.validators.NumberUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.validators.NumberInRange.isInLongRange;

public class LongParser {

    private LongParser() {}

    private final static long DEFAULT_VALUE = 0L;

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toLong(value), DEFAULT_VALUE);
    }

    public static Long toLong(Object value) {
        if (isNull(value)) return null;
        if (isLong(value)) return (Long) value;
        if (isNumber(value) && isInLongRange((Number)value))
            return NumberUtils.getBigInteger((Number)value).longValueExact();

        return null;
    }
}
