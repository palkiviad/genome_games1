package core;

import api.CoreModule;
import api.messages.MessagesSystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:37
 * To change this template use File | Settings | File Templates.
 */
public class Server extends Thread {
    private final static Logger logger = LogManager.getLogger(Server.class);
    private MessagesSystem messages;

    public void initialize() {
        logger.info("starting initialize modules");
        logger.info("creating message system");
        messages = new MessagesSystem();
        logger.info("initialize services");
        List<CoreModule> list = ServicesFactory.createModules();
        for (CoreModule module : list) {
            startModule(module);
        }
        setDaemon(true);
        start();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    private void startModule(CoreModule module) {
        module.initialize();
        module.registerInMessageSystem(messages);
        Thread thread = new Thread(module);
        thread.setName(module.toString() + "_" + module.getAddress());
        thread.setDaemon(true);
        thread.start();
    }

}
