package uz.elmurodov.repository.column;

import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.column.Column;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 8:35 PM. 1/19/2022
 */
public class ColumnRepository extends BaseRepository<ColumnCreateDto, ColumnUpdateDto, Column, Long, Boolean> {
    @Override
    public Long create(ColumnCreateDto dto) {
        return null;
    }

    @Override
    public Boolean block(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean unblock(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean update(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean delete(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public Column get(Long id) {
        return null;
    }

    @Override
    public List<Column> list(Long id) {
        return null;
    }
}
