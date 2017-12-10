package pro.boto.datatype.parser;

import static pro.boto.datatype.classifiers.Classifier.isInteger;
import static pro.boto.datatype.classifiers.Classifier.isString;

public class StringParser {

    public static String toString(Object value) {
        if (value == null) return null;
        if (isString(value)) return (String) value;
        return null;
    }
}
