package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.classifiers.NumberClassifier.isInShortRange;
import static pro.boto.datatype.parser.BigIntegerParser.toBigInteger;

public class ShortParser {

    private static final short DEFAULT_VALUE = 0;

    private ShortParser() {}

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toShort(value), DEFAULT_VALUE);
    }

    public static Short toShort(Object value) {
        if (isNull(value) || isShort(value)) {
            return (Short) value;
        }

        Short converted = null;
        if (isNumber(value) && isInShortRange((Number)value)) {
            converted = toBigInteger(value).shortValueExact();
        }

        return converted;
    }
}
