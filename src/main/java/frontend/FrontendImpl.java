package frontend;

import api.entity.Account;
import api.entity.Session;
import api.services.Service;
import api.services.Frontend;
import api.services.ServiceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 4:50
 * To change this template use File | Settings | File Templates.
 */
public class FrontendImpl extends Service implements Frontend {
    private static Logger logger = LogManager.getLogger(FrontendImpl.class);

    private final Map<String, Session> sessions = new HashMap<String, Session>();


    @Override
    public void initialize() {


    }

    @Override
    public void registered(Account account) {
        logger.info("user with token " + account.getToken() + " was registered");
        logger.info("creating new session for user " + account.getId());
        Session session = new Session(account);
        logger.info("new session was created with id " + session.getSessionId());
        sessions.put(session.getSessionId(), session);
    }

    @Override
    public void authenticated(String sessionId, Account account) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getType() {
        return ServiceType.FRONTEND.ordinal();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
