package api;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 4:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class Message {
    private final SubscriberAddress target;
    private final SubscriberAddress sender;
    private final String name;

    public Message(SubscriberAddress target, SubscriberAddress sender) {
        this.target = target;
        this.sender = sender;
        name = getClass().getName() + " sender is:  " + sender.toString() + ", target is: " + target.toString();
    }

    public SubscriberAddress getTarget() {
        return target;
    }

    public SubscriberAddress getSender() {
        return sender;
    }

    public abstract void execute(MessageSystemSubscriber subscriber);

    @Override
    public String toString() {
        return name;
    }
}
