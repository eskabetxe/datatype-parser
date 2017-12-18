package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.validators.NumberUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.validators.NumberInRange.isInIntegerRange;

public class IntegerParser  {

    private IntegerParser() {}

    private final static int DEFAULT_VALUE = 0;

    public static int toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toInteger(value), DEFAULT_VALUE);
    }

    public static Integer toInteger(Object value) {
        if (isNull(value)) return null;
        if (isInteger(value)) return (Integer) value;
        if (isNumber(value) && isInIntegerRange((Number)value))
            return NumberUtils.getBigInteger((Number)value).intValueExact();

        return null;
    }

}
