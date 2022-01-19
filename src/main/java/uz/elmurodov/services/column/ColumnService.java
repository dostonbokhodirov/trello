package uz.elmurodov.services.column;

import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Doston Bokhodirov, Wed 8:59 PM. 1/19/2022
 */
public class ColumnService extends BaseService<ColumnRepository, ColumnCreateDto, ColumnUpdateDto, Long> {
    @Override
    public ResponseEntity<Data<?>> create(ColumnCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> block(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> update(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        return null;
    }
}
