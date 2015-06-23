package api.messages;

import api.services.Frontend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 1:04
 * To change this template use File | Settings | File Templates.
 */
public abstract class MessageToFrontend extends Message {

    private static Logger logger = LogManager.getLogger(MessageToAccountService.class);

    public MessageToFrontend(SubscriberAddress target, SubscriberAddress sender) {
        super(target, sender);
    }

    @Override
    public void execute(MessageSystemSubscriber subscriber) {
        if (subscriber instanceof Frontend) {
            exec((Frontend) subscriber);
            return;
        }
        logger.error("subscriber type not supported! " + subscriber.getClass().getName());
    }

    public abstract void exec(Frontend subscriber);

}
