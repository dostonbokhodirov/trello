package uz.elmurodov.services.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.auth.AuthUserRepository;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.column.Column;
import uz.elmurodov.services.BaseService;

import java.util.List;


public class ColumnService extends BaseService<ColumnRepository, ColumnCreateDto, ColumnUpdateDto, Long> {
    private static final ColumnRepository repository = UNIContainer.getBean(ColumnRepository.class);
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

    public ResponseEntity<Data<?>> list(long userId, long projectId) {
        try {
            List<Column> columns = repository.list(projectId);
            return new ResponseEntity<>(new Data<>(columns));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

    }
}
