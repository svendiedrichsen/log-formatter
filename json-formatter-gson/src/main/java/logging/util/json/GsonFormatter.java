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

    public String format(LogRecord record) {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(LogRecord.class, new LogRecordSerializer());
        return gson.create().toJson(record);
    }

}
