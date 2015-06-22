package api;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:49
 * To change this template use File | Settings | File Templates.
 */
public interface MessageSystemSubscriber {
    SubscriberAddress getAddress();

    void registerInMessageSystem(MessagesSystem system);
}
