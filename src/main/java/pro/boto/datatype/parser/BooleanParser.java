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
        if (isNull(value) || isBoolean(value)) {
            return (Boolean) value;
        }

        Boolean converted = null;
        if (isNumber(value)) {
            converted = toBooleanObject(NumberParser.toInteger(value));
        } else if (isString(value)) {
            converted = toBooleanObject((String)value);
        }
        return converted;
    }

}
