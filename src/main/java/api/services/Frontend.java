package api.services;

import api.entity.Account;
import api.messages.MessageSystemSubscriber;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:45
 * To change this template use File | Settings | File Templates.
 */
public interface Frontend  extends MessageSystemSubscriber {
    void registered(Account account);
    void authenticated(String sessionId, Account account);


}
