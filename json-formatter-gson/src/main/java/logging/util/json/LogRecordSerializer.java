package logging.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogRecord;

/**
 * @author sdiedrichsen
 * @version $Id$
 * @since 29.04.18
 */
public class LogRecordSerializer implements JsonSerializer<LogRecord> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public JsonElement serialize(LogRecord logRecord, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject record = new JsonObject();

        record.addProperty("millis", logRecord.getMillis());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(logRecord.getMillis()), ZoneId.systemDefault());
        record.addProperty("timestamp", FORMATTER.format(zonedDateTime));
        record.addProperty("level", logRecord.getLevel().getName());
        record.addProperty("sequenceNumber", logRecord.getSequenceNumber());
        record.addProperty("threadID", logRecord.getThreadID());
        record.addProperty("message", logRecord.getMessage());

        if ( logRecord.getThrown() != null) {
            Throwable thrown = logRecord.getThrown();
            thrown.getStackTrace();
            record.add("thrown", jsonSerializationContext.serialize(thrown));
        }
        return record;
    }
}
