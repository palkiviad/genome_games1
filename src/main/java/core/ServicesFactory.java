package core;

import accounts.AccountServiceImpl;
import api.services.Service;
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

    public static List<Service> createModules() {
        List<Service> list = new LinkedList<Service>();
        list.add(createFrontend());
        list.add(createDataBase());
        list.add(createAccountService());
        list.add(createResourcesService());
        list.add(createGameCore());
        return list;
    }

    private static Service createGameCore() {
        return new GameCoreServiceImpl();
    }


    private static Service createAccountService() {
        return new AccountServiceImpl();
    }

    private static Service createResourcesService() {
        return new ResourceServiceImpl();
    }

    private static Service createDataBase() {
        return new DataBaseServiceImpl();
    }

    private static Service createFrontend() {
        return new FrontendImpl();
    }
}
