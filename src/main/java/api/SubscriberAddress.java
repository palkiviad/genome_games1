package api;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 3:50
 * To change this template use File | Settings | File Templates.
 */
public class SubscriberAddress {
    private static AtomicInteger address = new AtomicInteger();
    private final int addressId;

    public SubscriberAddress() {
        addressId = address.incrementAndGet();
    }

    @Override
    public int hashCode() {
        return addressId;
    }
}
