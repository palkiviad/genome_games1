package core;

import api.messages.Message;
import api.messages.MessagesSystem;
import api.services.Frontend;
import api.services.Service;
import api.services.ServiceType;
import frontend.messages.AskRegisterMessage;
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
        List<Service> list = ServicesFactory.createModules();
        for (Service module : list) {
            startModule(module);
        }
        setDaemon(true);
        start();
        Message message = new AskRegisterMessage(messages.getAddress(ServiceType.FRONTEND.ordinal()), null, "mumbu-umbu");
        messages.sendMessage(message);
        Message message1 = new AskRegisterMessage(messages.getAddress(ServiceType.FRONTEND.ordinal()), null, "hruku-umbu");
        messages.sendMessage(message1);
        Message message2 = new AskRegisterMessage(messages.getAddress(ServiceType.FRONTEND.ordinal()), null, "hruku-umbu");
        messages.sendMessage(message2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    private void startModule(Service module) {
        module.initialize();
        module.registerInMessageSystem(messages);
        Thread thread = new Thread(module);
        thread.setName(module.toString() + "_" + module.getAddress());
        thread.setDaemon(true);
        thread.start();
    }

}
