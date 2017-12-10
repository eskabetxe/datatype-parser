package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isByte;
import static pro.boto.datatype.classifiers.Classifier.isChar;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class CharParser {

    private final static char DEFAULT_VALUE = '\u0000';

    public static char toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toChar(value), DEFAULT_VALUE);
    }

    public static Character toChar(Object value) {
        if (isNull(value)) return null;
        if (isChar(value)) return (Character) value;
        return null;
    }
}
