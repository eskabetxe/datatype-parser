package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static org.apache.commons.lang3.BooleanUtils.toBooleanObject;
import static pro.boto.datatype.classifiers.Classifier.*;
import static pro.boto.datatype.parser.IntegerParser.toInteger;

public final class BooleanParser {

    private static final boolean DEFAULT_VALUE = false;

    private BooleanParser() {}

    public static boolean toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toBoolean(value), DEFAULT_VALUE);
    }

    public static Boolean toBoolean(Object value){
        if (isNull(value) || isBoolean(value)) {
            return (Boolean) value;
        }

        Boolean converted = null;
        if (isNumber(value)) {
            converted = toBooleanObject(toInteger(value));
        } else if (isString(value)) {
            converted = toBooleanObject((String)value);
        }
        return converted;
    }

}
