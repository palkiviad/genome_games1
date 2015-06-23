package api.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public class Session {
    private static Logger logger = LogManager.getLogger(Session.class);

    private final String sessionId;
    private Account account;

    public Session(Account account) {
        this.sessionId = UUID.randomUUID().toString();
        this.account = account;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Account getAccount() {
        return account;
    }

}
