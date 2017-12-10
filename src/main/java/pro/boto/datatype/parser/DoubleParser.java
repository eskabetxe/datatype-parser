package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isDouble;
import static pro.boto.datatype.classifiers.Classifier.isInteger;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class DoubleParser {

    private final static double DEFAULT_VALUE = 0D;

    public static double toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toDouble(value), DEFAULT_VALUE);
    }

    public static Double toDouble(Object value) {
        if (isNull(value)) return null;
        if (isDouble(value)) return (Double) value;
        return null;
    }
}
