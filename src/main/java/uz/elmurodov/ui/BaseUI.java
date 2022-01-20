package uz.elmurodov.ui;

import uz.elmurodov.services.BaseService;

/**
 * @author Doston Bokhodirov, Wed 4:31 PM. 1/19/2022
 */
public abstract class BaseUI<S extends BaseService> {
    public abstract void create();
    public abstract void block();
    public abstract void unblock();
    public abstract void delete();
    public abstract void update();
    public abstract void get();
    public abstract void list();

    protected S service;
}
