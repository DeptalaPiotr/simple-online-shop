package pl.deptala.piotr.onlineshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.onlineshop.api.exceptions.UserNotFoundException;
import pl.deptala.piotr.onlineshop.repository.UserRepository;
import pl.deptala.piotr.onlineshop.repository.entity.UserEntity;
import pl.deptala.piotr.onlineshop.service.mapper.UserMapper;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // C - create
    public UserModel create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        UserEntity userEntity = userMapper.from(userModel);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserModel savedModel = userMapper.from(savedUserEntity);
        LOGGER.info("create(...) " + savedModel);
        return savedModel;
    }

    // R - read
    public void read(Long id) throws UserNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.orElseThrow(
                () -> new UserNotFoundException("User with ID:" + id + " not found "));
        UserModel userModel = userMapper.from(userEntity);
        LOGGER.info("read(...)" + userModel);
    }

    // U - update
    public void update() {
        LOGGER.info("update()");
        LOGGER.info("update(...)");
    }

    // D - delete
    public void delete() {
        LOGGER.info("delete()");
        LOGGER.info("delete(...)");
    }

    // L - list
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
