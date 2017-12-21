package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;

import static org.apache.commons.lang3.BooleanUtils.toBooleanObject;
import static pro.boto.datatype.classifiers.Classifier.*;

public class BooleanParser {

    private final static boolean DEFAULT_VALUE = false;

    private BooleanParser() {}

    public static boolean toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toBoolean(value), DEFAULT_VALUE);
    }

    public static Boolean toBoolean(Object value){
        if (isNull(value)) return null;

        Boolean valid = null;
        if (isBoolean(value)) {
            valid = (Boolean) value;
        } else if (isNumber(value)) {
            valid = toBooleanObject(NumberParser.toInteger(value));
        } else if (isString(value)) {
            valid = toBooleanObject((String)value);
        }
        return valid;
    }

}
