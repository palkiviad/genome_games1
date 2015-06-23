package api.messages;

import api.AccountService;
import api.MessageSystemSubscriber;
import api.SubscriberAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class MessageToAccountService extends Message {
    private final static Logger logger = LogManager.getLogger(MessageToAccountService.class);

    public MessageToAccountService(SubscriberAddress target, SubscriberAddress sender) {
        super(target, sender);
    }

    @Override
    public final void execute(MessageSystemSubscriber subscriber) {
        if (subscriber instanceof AccountService) {
            exec((AccountService) subscriber);
        }
        logger.error("subscriber type not supported! " + subscriber.getClass().getName());
    }

    public abstract void exec(AccountService subscriber) ;


}
