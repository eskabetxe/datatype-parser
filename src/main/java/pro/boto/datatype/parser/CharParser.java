package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isChar;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public class CharParser {

    private static final char DEFAULT_VALUE = '\u0000';

    private CharParser() {}

    public static char toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toChar(value), DEFAULT_VALUE);
    }

    public static Character toChar(Object value) {
        if (isNull(value) || isChar(value)) {
            return (Character) value;
        }
        return null;
    }
}
