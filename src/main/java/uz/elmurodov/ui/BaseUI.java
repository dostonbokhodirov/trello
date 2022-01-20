package uz.elmurodov.ui;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.services.BaseService;

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
