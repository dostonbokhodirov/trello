package uz.elmurodov.repository;

import lombok.SneakyThrows;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.security.Auditable;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 *
 * @param <CR> -> create dto
 * @param <D> -> update dto
 * @param <E> -> entity
 * @param <K> -> key
 */
public abstract class BaseRepository<
        CR extends GenericBaseDto,
        D extends GenericDto,
        E extends Auditable,
        K extends Serializable> {
    public abstract K create(CR dto);

    public abstract boolean block(K id);

    public abstract boolean unblock(K id);

    public abstract boolean update(D dto);

    public abstract boolean delete(K id);

    public abstract E get(K id);

    public abstract List<E> list();


    protected Connection connection = UNIContainer.getBean(Connection.class);
    private Object[] args;

    protected Serializable callProcedure(String query, int outType) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            ResultSet resultSet = statement.executeQuery();
            return prepareResultSet(resultSet, outType);
        } catch (SQLException ex) {
            throw new CustomerSQLException(ex.getMessage(), ex.getCause());
        }
    }

    @SneakyThrows
    private Serializable prepareResultSet(ResultSet resultSet, int outType) {
        if (resultSet.next()) {
            return switch (outType) {
                case Types.VARCHAR -> resultSet.getString(1);
                case Types.BIGINT -> resultSet.getLong(1);
                case Types.BOOLEAN -> resultSet.getBoolean(1);
                default -> throw new IllegalStateException("Unexpected value: " + outType);
            };
        }
        return null;
    }

    @SneakyThrows
    private void prepareToExecute(CallableStatement statement) {
        for (int i = 0; i < this.args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    protected void prepareArguments(Object... args) {
        this.args = args;
    }

}
