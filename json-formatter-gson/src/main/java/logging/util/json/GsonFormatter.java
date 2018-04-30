package logging.util.json;

import com.google.gson.GsonBuilder;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Implementation of a {@link Formatter}.
 *
 * @author sdiedrichsen
 * @version $Id$
 * @since 26.04.18
 */
public class GsonFormatter extends Formatter {

    private static GsonBuilder builder;

    static {
        builder = new GsonBuilder();
        builder.registerTypeAdapter(LogRecord.class, new LogRecordSerializer());
    }

    public String format(LogRecord record) {
        return builder.create().toJson(record) + "\n";
    }

}
