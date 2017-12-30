package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.isInIntegerRange;
import static pro.boto.datatype.parser.NumberParser.toBigInteger;

public class IntegerParser  {

    private final static int DEFAULT_VALUE = 0;

    private IntegerParser() {}

    public static int toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toInteger(value), DEFAULT_VALUE);
    }

    public static Integer toInteger(Object value) {
        if (isNull(value) || isInteger(value)) {
            return (Integer) value;
        }

        Integer converted = null;
        if (isNumber(value) && isInIntegerRange((Number)value)) {
            converted = toBigInteger(value).intValueExact();
        }

        return converted;
    }

}
