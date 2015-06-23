package frontend.messages;

import api.AccountService;
import api.SubscriberAddress;
import api.messages.MessageToAccountService;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 23.06.15
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class RegisterUserMessage extends MessageToAccountService {


    public RegisterUserMessage(SubscriberAddress target, SubscriberAddress sender) {
        super(target, sender);
    }

    @Override
    public void exec(AccountService subscriber) {

    }


}
