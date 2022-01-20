package uz.elmurodov.repository.column;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.column.Column;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class ColumnRepository extends BaseRepository<ColumnCreateDto,
        ColumnUpdateDto,
        Column,
        Long> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public Long create(ColumnCreateDto dto) {
        return null;
    }

    @Override
    public boolean block(Long dto) {
        return true;
    }

    @Override
    public boolean unblock(Long id) {
        return true;
    }

    @Override
    public boolean update(ColumnUpdateDto dto) {
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

    @Override
    public Column get(Long id) {
        return null;
    }

    @Override
    public List<Column> list() {
        return null;
    }

    public List<Column> list(long projectId) {
        prepareArguments(projectId);
        String jsonData = (String) callProcedure(property.get("column.list"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonData, new TypeToken<List<Column>>() {
        }.getType());
    }
}
