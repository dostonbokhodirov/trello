package uz.elmurodov.services;

import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;

import java.io.Serializable;
import java.util.List;


/**
 * @param <R> -> Repository
 */
public abstract class BaseService<R extends BaseRepository,
        CR extends GenericBaseDto,
        D extends GenericDto,
        K extends Serializable> {
    protected R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public abstract ResponseEntity<Data<?>> create(CR dto);

    public abstract ResponseEntity<Data<?>> get(K id);

    public abstract ResponseEntity<Data<?>> block(D dto);

    public abstract ResponseEntity<Data<?>> unblock(D dto);

    public abstract ResponseEntity<Data<?>> update(D dto);

    public abstract ResponseEntity<Data<?>> delete(K id);

    public abstract ResponseEntity<Data<?>> list();

}
