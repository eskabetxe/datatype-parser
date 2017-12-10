package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isFloat;
import static pro.boto.datatype.classifiers.Classifier.isLong;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class LongParser {

    private final static long DEFAULT_VALUE = 0L;

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toLong(value), DEFAULT_VALUE);
    }

    public static Long toLong(Object value) {
        if (isNull(value)) return null;
        if (isLong(value)) return (Long) value;
        return null;
    }
}
