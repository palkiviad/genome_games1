package resources;

import api.services.Service;
import api.services.ResourceService;
import api.services.ServiceType;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 5:03
 * To change this template use File | Settings | File Templates.
 */
public class ResourceServiceImpl extends Service implements ResourceService {


    @Override
    public void initialize() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getType() {
        return ServiceType.RESOURCES.ordinal();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
