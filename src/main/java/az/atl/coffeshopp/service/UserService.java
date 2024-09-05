package az.atl.coffeshopp.service;

import az.atl.coffeshopp.dao.entity.UserEntity;
import az.atl.coffeshopp.dao.repository.UserRepository;
import az.atl.coffeshopp.exception.NoSuchUserException;
import az.atl.coffeshopp.mapper.UserMapper;
import az.atl.coffeshopp.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseGet(null);
        if (Objects.nonNull(user)) {
            return userMapper.fromEntityToDto(user);
        }else {
            throw new NoSuchUserException("NO SUCH USER");
        }
    }

    public List<UserDto> findAllUsers(){
        List<UserEntity> all = userRepository.findAll();
        return userMapper.fromEntityListToDtoList(all);
    }

    public void deleteUserById(Long id){
        userRepository.findById(id).orElseThrow(
                () -> new NoSuchUserException("NO_SUCH_USER")
        );
        userRepository.deleteById(id);
        log.info("User deleted successfully");
    }
}
