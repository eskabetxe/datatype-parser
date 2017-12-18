package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.validators.NumberUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.validators.NumberInRange.isInByteRange;

public class ByteParser {

    private final static byte DEFAULT_VALUE = 0;

    public static byte toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toByte(value), DEFAULT_VALUE);
    }

    public static Byte toByte(Object value) {
        if (isNull(value)) return null;
        if (isByte(value)) return (Byte) value;
        if (isNumber(value) && isInByteRange((Number)value))
            return NumberUtils.getBigInteger((Number)value).byteValueExact();

        return null;
    }
}
