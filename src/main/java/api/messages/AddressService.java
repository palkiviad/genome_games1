package api.messages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 24.06.15
 * Time: 1:41
 * To change this template use File | Settings | File Templates.
 */
public class AddressService {

    private static Logger logger = LogManager.getLogger(AddressService.class);
    private final ConcurrentMap<Integer, CopyOnWriteArrayList<SubscriberAddress>> map = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<SubscriberAddress>>();

    public void addAddress(MessageSystemSubscriber subscriber) {
        logger.info("add new subscriber address " + subscriber.getType());
        CopyOnWriteArrayList<SubscriberAddress> list = map.get(subscriber.getType());
        if (list == null) {
            list = new CopyOnWriteArrayList<SubscriberAddress>();
            map.put(subscriber.getType(), list);
        }
        list.add(subscriber.getAddress());
    }

    public SubscriberAddress getAddressFor(int type) {
        CopyOnWriteArrayList<SubscriberAddress> list = map.get(type);
        if (list != null) {
            return list.get(0);
        }
        logger.fatal("can't find address for class " + type);
        throw new IllegalStateException("can't find address for class " + type);
    }
}
