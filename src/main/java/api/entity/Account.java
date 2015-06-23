package api.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private int id;
    private String token;

    public Account(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
