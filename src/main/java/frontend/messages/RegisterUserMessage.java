package frontend.messages;

import api.entity.Account;
import api.messages.Message;
import api.services.AccountService;
import api.messages.SubscriberAddress;
import api.messages.MessageToAccountService;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 23.06.15
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class RegisterUserMessage extends MessageToAccountService {


    private final String token;

    public RegisterUserMessage(SubscriberAddress target, SubscriberAddress sender, String token) {
        super(target, sender);
        this.token = token;
    }

    @Override
    public void exec(AccountService subscriber) {
        Account account = subscriber.registerAccount(token);
        Message callback = new RegisteredAccountMessage(getSender(), getTarget(), account);
        subscriber.getMessageSystem().sendMessage(callback);
    }


}
