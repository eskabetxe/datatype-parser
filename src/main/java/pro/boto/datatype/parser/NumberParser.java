package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static pro.boto.datatype.classifiers.Classifier.isInteger;


public class NumberParser {

    public static Integer toInteger(Object value) {
        return IntegerParser.toInteger(value);
    }
}
