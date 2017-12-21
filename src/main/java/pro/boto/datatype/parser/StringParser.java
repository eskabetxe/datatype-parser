package pro.boto.datatype.parser;

import java.text.NumberFormat;

import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.NumberParser.*;

public class StringParser {

    private StringParser() {}

    public static String toString(Object value) {
        if (isNull(value) || isString(value)) {
            return (String) value;
        }
        String converted = null;
        if (isComplementInteger(value)) {
            converted = NumberFormat.getInstance().format(toBigInteger(value));
        } else if (isFloatingPoint(value)) {
            converted = NumberFormat.getInstance().format(toBigDecimal(value));
        }

        return isNull(converted)?converted:converted.trim();
    }
}
