package gameCore;

import api.services.Service;
import api.services.GameCoreService;
import api.services.ServiceType;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 4:55
 * To change this template use File | Settings | File Templates.
 */
public class GameCoreServiceImpl extends Service implements GameCoreService {


    @Override
    public void initialize() {
        // there is need to be written some code
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getType() {
        return ServiceType.GAME_CORE.ordinal();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
