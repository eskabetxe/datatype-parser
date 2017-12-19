package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.validators.NumberUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.validators.NumberInRange.isInShortRange;

public class ShortParser {

    private final static short DEFAULT_VALUE = 0;

    private ShortParser() {}

    public static long toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toShort(value), DEFAULT_VALUE);
    }

    public static Short toShort(Object value) {
        if (isNull(value)) return null;
        if (isShort(value)) return (Short) value;
        if (isNumber(value) && isInShortRange((Number)value))
            return NumberUtils.getBigInteger((Number)value).shortValueExact();

        return null;
    }
}
