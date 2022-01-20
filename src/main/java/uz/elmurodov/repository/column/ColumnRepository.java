package uz.elmurodov.repository.column;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.column.Column;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 8:35 PM. 1/19/2022
 */
public class ColumnRepository extends BaseRepository<ColumnCreateDto, ColumnUpdateDto, Column, Long, Boolean> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

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
    public List<Column> list() {
        return null;
    }

    public List<Column> list(long projectId) {
        prepareArguments(projectId);
        String jsonData = (String) callProcedure(property.get("column.list"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonData, new TypeToken<List<Column>>(){}.getType());
    }
}
