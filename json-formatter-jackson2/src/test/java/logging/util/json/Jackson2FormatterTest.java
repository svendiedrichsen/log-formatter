package logging.util.json;

import org.testng.annotations.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jackson2FormatterTest {

    private static Logger LOG;

    static {
        LOG = Logger.getLogger("TestLogger");
        LOG.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Jackson2Formatter());
        LOG.addHandler(handler);
    }

    @Test
    public void testLogging() {
        LOG.info("Info message");
        LOG.warning("Warning message");
        LOG.severe("Severe message");
    }

    @Test
    public void testExceptionLogging() {
        try {
            throw new Exception("Some error");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Some message", e);
        }
    }

}