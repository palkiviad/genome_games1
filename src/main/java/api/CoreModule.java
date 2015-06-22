package api;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:53
 * To change this template use File | Settings | File Templates.
 */
public abstract class CoreModule implements Runnable, MessageSystemSubscriber {

    private final SubscriberAddress address = new SubscriberAddress();
    protected MessagesSystem messages;

    @Override
    public SubscriberAddress getAddress() {
        return address;
    }

    @Override
    public void registerInMessageSystem(MessagesSystem messages) {
        this.messages = messages;
        messages.registerSubscriber(this);
    }

    public abstract void initialize();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                messages.executeFor(this);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }

    @Override
    public String toString() {
        return getClass().getName();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
