package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.isInFloatRange;
import static pro.boto.datatype.parser.NumberParser.toBigDecimal;

public class FloatParser {

    private final static float DEFAULT_VALUE = 0.0F;

    private FloatParser() {}

    public static float toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toFloat(value), DEFAULT_VALUE);
    }

    public static Float toFloat(Object value) {
        if (isNull(value)) return null;
        if (isFloat(value)) return (Float) value;
        if (isNumber(value) && isInFloatRange((Number)value))
            return toBigDecimal(value).floatValue();

        return null;
    }
}
