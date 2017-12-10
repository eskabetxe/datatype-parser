package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isDouble;
import static pro.boto.datatype.classifiers.Classifier.isFloat;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class FloatParser {

    private final static float DEFAULT_VALUE = 0.0F;

    public static float toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toFloat(value), DEFAULT_VALUE);
    }

    public static Float toFloat(Object value) {
        if (isNull(value)) return null;
        if (isFloat(value)) return (Float) value;
        return null;
    }
}
