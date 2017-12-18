package pro.boto.datatype.parser;

public class NumberParser {

    public static Byte toByte(Object value) {
        return ByteParser.toByte(value);
    }

    public static Short toShort(Object value) {
        return ShortParser.toShort(value);
    }

    public static Integer toInteger(Object value) {
        return IntegerParser.toInteger(value);
    }

    public static Long toLong(Object value) {
        return LongParser.toLong(value);
    }

    public static Float toFloat(Object value) {
        return FloatParser.toFloat(value);
    }

    public static Double toDouble(Object value) {
        return DoubleParser.toDouble(value);
    }

}
