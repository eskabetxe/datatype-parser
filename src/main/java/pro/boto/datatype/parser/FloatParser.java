package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.classifiers.NumberClassifier.isInFloatRange;
import static pro.boto.datatype.parser.BigDecimalParser.toBigDecimal;

public class FloatParser {

    private static final float DEFAULT_VALUE = 0.0F;

    private FloatParser() {}

    public static float toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toFloat(value), DEFAULT_VALUE);
    }

    public static Float toFloat(Object value) {
        if (isNull(value) || isFloat(value)) {
            return (Float) value;
        }

        Float converted = null;
        if (isNumber(value) && isInFloatRange((Number)value)) {
            converted = toBigDecimal(value).floatValue();
        }

        return converted;
    }
}
