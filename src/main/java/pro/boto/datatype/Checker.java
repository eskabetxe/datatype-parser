package pro.boto.datatype;

import static org.apache.commons.lang3.BooleanUtils.negate;

public class Checker {

    public static boolean isNull(Object value){
        return value == null;
    }

    public static boolean isNotNull(Object value){
        return negate(isNull(value));
    }
}
