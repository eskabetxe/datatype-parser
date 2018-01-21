package pro.boto.datatype.parser;

import java.util.Date;

import static pro.boto.datatype.classifiers.Classifier.isDate;
import static pro.boto.datatype.classifiers.Classifier.isNull;

public final class DateParser {

    private DateParser() { }

    public static Date toDate(Object value) {
        if (isNull(value) || isDate(value)) {
            return (Date) value;
        }
        Long parsed = LongParser.toLong(value);
        if (isNull(parsed)) return null;

        return new Date(parsed);
    }
}
