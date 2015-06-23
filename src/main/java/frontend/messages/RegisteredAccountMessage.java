package frontend.messages;

import api.entity.Account;
import api.messages.Message;
import api.messages.MessageSystemSubscriber;
import api.messages.MessageToFrontend;
import api.messages.SubscriberAddress;
import api.services.Frontend;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 2:27
 * To change this template use File | Settings | File Templates.
 */
public class RegisteredAccountMessage extends MessageToFrontend {

    private final Account account;
    public RegisteredAccountMessage(SubscriberAddress target, SubscriberAddress sender, Account account) {
        super(target, sender);
        this.account = account;
    }


    @Override
    public void exec(Frontend frontend) {
        frontend.registered(account);
    }
}
