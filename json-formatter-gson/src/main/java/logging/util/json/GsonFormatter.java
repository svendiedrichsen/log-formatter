package logging.util.json;

import com.google.gson.Gson;

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
        return new Gson().toJson(record);
    }

}
