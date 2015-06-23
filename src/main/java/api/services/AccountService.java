package api.services;

import api.entity.Account;
import api.entity.Session;
import api.messages.MessageSystemSubscriber;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:45
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService extends MessageSystemSubscriber{

    Account registerAccount(String token);

    void authenticate(Session session, int accountId);

    boolean isAuthenticated(int accountId);

    void logoff(Session session);

}
