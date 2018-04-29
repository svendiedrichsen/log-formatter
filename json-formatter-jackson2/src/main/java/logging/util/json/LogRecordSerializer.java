package logging.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
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
public class LogRecordSerializer extends StdSerializer<LogRecord> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public LogRecordSerializer() {
        this(LogRecord.class);
    }

    public LogRecordSerializer(Class<LogRecord> t) {
        super(t);
    }

    public void serialize(LogRecord logRecord, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("message", logRecord.getMessage());
        jsonGenerator.writeNumberField("millis", logRecord.getMillis());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(logRecord.getMillis()), ZoneId.systemDefault());
        jsonGenerator.writeStringField("timestamp", FORMATTER.format(zonedDateTime));

        jsonGenerator.writeEndObject();

    }

}
