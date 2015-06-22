package core;

import accounts.AccountServiceImpl;
import api.CoreModule;
import database.DataBaseServiceImpl;
import frontend.FrontendImpl;
import gameCore.GameCoreServiceImpl;
import resources.ResourceServiceImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Алкивиад
 * Date: 22.06.15
 * Time: 4:43
 * To change this template use File | Settings | File Templates.
 */
public class ServicesFactory {

    public static List<CoreModule> createModules() {
        List<CoreModule> list = new LinkedList<CoreModule>();
        list.add(createFrontend());
        list.add(createDataBase());
        list.add(createAccountService());
        list.add(createResourcesService());
        list.add(createGameCore());
        return list;
    }

    private static CoreModule createGameCore() {
        return new GameCoreServiceImpl();
    }


    private static CoreModule createAccountService() {
        return new AccountServiceImpl();
    }

    private static CoreModule createResourcesService() {
        return new ResourceServiceImpl();
    }

    private static CoreModule createDataBase() {
        return new DataBaseServiceImpl();
    }

    private static CoreModule createFrontend() {
        return new FrontendImpl();
    }
}
