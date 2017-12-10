package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isLong;
import static pro.boto.datatype.classifiers.Classifier.isNull;
import static pro.boto.datatype.classifiers.Classifier.isShort;

public class ShortParser {

    private final static short DEFAULT_VALUE = 0;

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toShort(value), DEFAULT_VALUE);
    }

    public static Short toShort(Object value) {
        if (isNull(value)) return null;
        if (isShort(value)) return (Short) value;
        return null;
    }
}
