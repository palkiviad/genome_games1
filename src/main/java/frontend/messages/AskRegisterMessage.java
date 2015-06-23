package frontend.messages;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 1:06
 * To change this template use File | Settings | File Templates.
 */

import api.messages.Message;
import api.messages.MessageToFrontend;
import api.messages.SubscriberAddress;
import api.services.Frontend;
import api.services.ServiceType;

/**
 * @Deprecated only in debug purposes
 */
@Deprecated
public class AskRegisterMessage extends MessageToFrontend {
    private final String token;

    public AskRegisterMessage(SubscriberAddress target, SubscriberAddress sender, String token) {
        super(target, sender);
        this.token = token;
    }

    @Override
    public void exec(Frontend frontend) {
        Message message = new RegisterUserMessage(frontend.getMessageSystem().getAddress(ServiceType.ACCOUNTS.ordinal()), getTarget(), token);
        frontend.getMessageSystem().sendMessage(message);
    }
}
