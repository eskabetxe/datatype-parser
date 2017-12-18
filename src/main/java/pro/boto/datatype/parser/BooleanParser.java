package pro.boto.datatype.parser;

import org.apache.commons.lang3.ObjectUtils;
import pro.boto.datatype.Cleaner;

import static org.apache.commons.lang3.BooleanUtils.toBooleanObject;
import static pro.boto.datatype.classifiers.Classifier.*;

public class BooleanParser {

    private BooleanParser() {}

    private final static boolean DEFAULT_VALUE = false;

    public static boolean toPrimitive(Object value) {
        return ObjectUtils.defaultIfNull(toBoolean(value), DEFAULT_VALUE);
    }

    public static Boolean toBoolean(Object value){
        if (isNull(value)) return null;

        Boolean valid = null;
        if (isBoolean(value)) {
            valid = (Boolean) value;
        } else if (isInteger(value) || isDouble(value)) {
            valid = toBooleanObject(IntegerParser.toInteger(value));
        } else if (isString(value)) {
            String sValue = Cleaner.trim((String)value);
            valid = toBooleanObject(StringParser.toString(value));
        }
        return valid;
    }

}
