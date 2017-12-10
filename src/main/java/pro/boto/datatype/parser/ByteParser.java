package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isByte;
import static pro.boto.datatype.classifiers.Classifier.isDouble;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class ByteParser {

    private final static byte DEFAULT_VALUE = 0;

    public static byte toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toByte(value), DEFAULT_VALUE);
    }

    public static Byte toByte(Object value) {
        if (isNull(value)) return null;
        if (isByte(value)) return (Byte) value;
        return null;
    }
}
