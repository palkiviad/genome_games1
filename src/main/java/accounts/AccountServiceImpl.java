package accounts;

import api.entity.Account;
import api.entity.Session;
import api.services.AccountService;
import api.services.Service;
import api.services.ServiceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 5:15
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceImpl extends Service implements AccountService {
    private final static Logger logger = LogManager.getLogger(AccountServiceImpl.class);

    private final Map<Integer, Session> authenticatedAccounts = new HashMap<Integer, Session>();
    private final Map<String, Account> registeredAccounts = new HashMap<String, Account>();
    private static int maxId = 0;

    @Override
    public void initialize() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Account registerAccount(String token) {
        logger.info("starting register user " + token);
        Account account = registeredAccounts.get(token);
        if (account == null) {
            logger.info("user with token " + token + " not found, creating new Account");
            maxId++;
            account = new Account(maxId, token);
            registeredAccounts.put(token, account);
        } else {
            logger.info("user already registered");
        }
        return account;
    }

    @Override
    public void authenticate(Session session, int accountId) {
        logger.info("trying authenticate user " + session.getClass() + " " + accountId);
        if (authenticatedAccounts.get(accountId) == null) {
            authenticatedAccounts.put(accountId, session);
        }
        String message = "can't authenticate account cause it's already authenticated!" + " accountId is " + accountId;
        logger.error(message);
        throw new IllegalStateException(message);
    }

    @Override
    public boolean isAuthenticated(int accountId) {
        return authenticatedAccounts.get(accountId) != null;
    }

    @Override
    public void logoff(Session session) {
        logger.info("user " + session.getAccount().getId() + "is logging off");
        authenticatedAccounts.remove(session.getAccount().getId());
    }

    @Override
    public int getType() {
        return ServiceType.ACCOUNTS.ordinal();
    }
}
