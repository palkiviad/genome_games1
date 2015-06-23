package database;

import api.services.Service;
import api.services.DatabaseService;
import api.services.ServiceType;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 5:04
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseServiceImpl extends Service implements DatabaseService {

    @Override
    public void initialize() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getType() {
        return ServiceType.DATA_BASE.ordinal();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
