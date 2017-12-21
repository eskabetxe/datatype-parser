package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.isInShortRange;
import static pro.boto.datatype.parser.NumberParser.toBigInteger;

public class ShortParser {

    private final static short DEFAULT_VALUE = 0;

    private ShortParser() {}

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toShort(value), DEFAULT_VALUE);
    }

    public static Short toShort(Object value) {
        if (isNull(value) || isShort(value)) {
            return (Short) value;
        }
        if (isNumber(value) && isInShortRange((Number)value)) {
            return toBigInteger(value).shortValueExact();
        }
        if (isString(value)) {

        }

        return null;
    }
}
