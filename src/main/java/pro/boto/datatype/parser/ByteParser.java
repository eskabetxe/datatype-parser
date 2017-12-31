package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.classifiers.NumberClassifier.isInByteRange;
import static pro.boto.datatype.parser.BigIntegerParser.toBigInteger;

public class ByteParser {

    private static final byte DEFAULT_VALUE = 0;

    private ByteParser() {}

    public static byte toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toByte(value), DEFAULT_VALUE);
    }

    public static Byte toByte(Object value) {
        if (isNull(value) || isByte(value)) {
            return (Byte) value;
        }
        Byte converted = null;
        if (isNumber(value) && isInByteRange((Number)value)) {
            return toBigInteger(value).byteValueExact();
        }

        return converted;
    }
}
