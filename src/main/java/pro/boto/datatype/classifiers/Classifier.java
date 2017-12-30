package pro.boto.datatype.classifiers;

import org.apache.commons.lang3.ClassUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public final class Classifier {

    private Classifier() {}

    protected static boolean isAssignable(Object value, Class<?> eClazz){
        return ClassUtils.isAssignable(value.getClass(), eClazz);
    }

    // primitive types
    public static boolean isBoolean(Object value){
        return isAssignable(value, Boolean.class);
    }

    public static boolean isByte(Object value){
        return isAssignable(value, Byte.class);
    }

    public static boolean isChar(Object value){
        return isAssignable(value, Character.class);
    }

    public static boolean isDouble(Object value){
        return isAssignable(value, Double.class);
    }

    public static boolean isFloat(Object value){
        return isAssignable(value, Float.class);
    }

    public static boolean isInteger(Object value){
        return isAssignable(value, Integer.class);
    }

    public static boolean isLong(Object value){
        return isAssignable(value, Long.class);
    }

    public static boolean isShort(Object value){
        return isAssignable(value, Short.class);
    }

    // data types
    public static boolean isBigDecimal(Object value){
        return isAssignable(value, BigDecimal.class);
    }

    public static boolean isBigInteger(Object value){
        return isAssignable(value, BigInteger.class);
    }

    public static boolean isDate(Object value){
        return isAssignable(value, Date.class);
    }

    public static boolean isNumber(Object value){
        return isAssignable(value, Number.class);
    }

    public static boolean isString(Object value){
        return isAssignable(value, String.class);
    }

    // other
    public static boolean isNull(Object value){
        return value == null;
    }

}
