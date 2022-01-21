package uz.elmurodov.services.user;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.auth.UserCreateDto;
import uz.elmurodov.dtos.auth.UserUpdateDto;
import uz.elmurodov.dtos.user.BlockDto;
import uz.elmurodov.dtos.user.UserDto;
import uz.elmurodov.repository.user.UserRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;

import java.util.List;

public class UserService extends AbstractService<UserRepository>
        implements GenericCrudService<UserDto, UserCreateDto, UserUpdateDto, Long>,
        GenericService<UserDto, GenericCriteria> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(UserCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        repository.delete(id);
        return new ResponseEntity<>(new Data<>(null));
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> list(GenericCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<Boolean>> block(BlockDto dto) {
        repository.block(dto);
        return null;
    }
}
