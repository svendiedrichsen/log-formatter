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

    public String format(LogRecord record) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(new LogRecordSerializer());
            objectMapper.registerModule(module);
            return objectMapper.writeValueAsString(record) + "\n";
        } catch (JsonProcessingException e) {
            System.err.println("Cannot format LogRecord: " + e.getMessage());
        }
        return "";
    }

}
