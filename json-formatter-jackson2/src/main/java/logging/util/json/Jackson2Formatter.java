package logging.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Implementation of a {@link Formatter}.
 *
 * @author sdiedrichsen
 * @version $Id$
 * @since 26.04.18
 */
public class Jackson2Formatter extends Formatter {

    private static ObjectMapper objectMapper;

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new LogRecordSerializer());
        objectMapper = new ObjectMapper()
                .registerModule(module);
    }

    public String format(LogRecord record) {
        try {
            return objectMapper.writer().writeValueAsString(record) + "\n";
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Cannot format LogRecord.", e);
        }
    }

}
