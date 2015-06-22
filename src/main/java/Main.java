import core.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private final static Logger logger = LogManager.getLogger("MainLog");
    private static Server server;
    public static void main(String[] args) {
        logger.info("server is starting!");
        server = new Server();
        server.initialize();
    }
}
