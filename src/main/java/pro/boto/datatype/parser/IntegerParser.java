package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isDouble;
import static pro.boto.datatype.classifiers.Classifier.isInteger;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class IntegerParser  {

    private final static int DEFAULT_VALUE = 0;

    public static int toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toInteger(value), DEFAULT_VALUE);
    }

    public static Integer toInteger(Object value) {
        if (isNull(value)) return null;
        if (isInteger(value)) return (Integer) value;
        if (isDouble(value)) return ((Double) value).intValue();
        return null;
    }
}
