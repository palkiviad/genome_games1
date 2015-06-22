package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 4:00
 * To change this template use File | Settings | File Templates.
 */
public class MessagesSystem {
    private final static Logger logger = LogManager.getLogger(MessagesSystem.class);

    private final Map <SubscriberAddress, ConcurrentLinkedQueue<Message>> messages
            = new HashMap<SubscriberAddress, ConcurrentLinkedQueue<Message>>();

    public void registerSubscriber(MessageSystemSubscriber subscriber) {
        if (messages.containsKey(subscriber.getAddress())) throw new IllegalStateException("can't register subscriber cause such addrress already registered " + subscriber.toString());
        logger.info("register subscriber "+ subscriber.toString());
        ConcurrentLinkedQueue<Message> queue = new ConcurrentLinkedQueue<Message>();
        messages.put(subscriber.getAddress(), queue);
    }

    public void sendMessage(Message message) {
        logger.info("Send new message: ", message);
        Queue <Message> queue = messages.get(message.getTarget());
        queue.add(message);
    }

    public void executeFor(MessageSystemSubscriber subscriber) {
        logger.info("trying execute messages for: "+ subscriber);
        Queue <Message> queue = messages.get(subscriber.getAddress());
        while (!queue.isEmpty()) {
            Message message = queue.poll();
            message.execute(subscriber);
            logger.info("execute", message);
        }
    }
}
