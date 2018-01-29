package pro.boto.datatype.parser;

import java.text.NumberFormat;

import static pro.boto.datatype.classifiers.Classifier.isNull;
import static pro.boto.datatype.classifiers.Classifier.isString;
import static pro.boto.datatype.classifiers.NumberClassifier.isComplementInteger;
import static pro.boto.datatype.classifiers.NumberClassifier.isFloatingPoint;
import static pro.boto.datatype.parser.BigDecimalParser.toBigDecimal;
import static pro.boto.datatype.parser.BigIntegerParser.toBigInteger;

public final class StringParser {

    private StringParser() { }

    public static String toString(Object value) {
        if (isNull(value) || isString(value)) {
            return (String) value;
        }

        String converted = null;
        if (isComplementInteger(value)) {
            converted = NumberFormat.getInstance().format(toBigInteger(value));
        } else if (isFloatingPoint(value)) {
            converted = NumberFormat.getInstance().format(toBigDecimal(value));
        } else if (value instanceof byte[]){
            converted = new String((byte[]) value);
        }
        return converted;
    }
}
