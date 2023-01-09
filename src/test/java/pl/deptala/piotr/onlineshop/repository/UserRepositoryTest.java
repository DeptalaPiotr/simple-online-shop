package pl.deptala.piotr.onlineshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.onlineshop.repository.entity.UserEntity;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void create(){

        // Given
        UserEntity testedUserEntity =new UserEntity();
        testedUserEntity.setName("Piotr");
        testedUserEntity.setShippingAddress("O!polska 15, 01-000 Test");

        // When
        UserEntity savedUserEntity = userRepository.save(testedUserEntity);

        // Then
        Assertions.assertNotNull(savedUserEntity, "Saved Entity ist NULL");
    }

}