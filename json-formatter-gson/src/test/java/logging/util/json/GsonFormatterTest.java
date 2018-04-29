package logging.util.json;

import logging.util.json.GsonFormatter;
import org.testng.annotations.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sdiedrichsen
 * @version $Id$
 * @since 26.04.18
 */
public class GsonFormatterTest {

    private static Logger LOG;

    static {
        LOG = Logger.getLogger("TestLogger");
        LOG.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new GsonFormatter());
        LOG.addHandler(handler);
    }

    @Test
    public void testSimpleLogging() {
        LOG.info("Some message");
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