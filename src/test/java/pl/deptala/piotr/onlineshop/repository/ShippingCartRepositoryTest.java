package pl.deptala.piotr.onlineshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;
import pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity;
import pl.deptala.piotr.onlineshop.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShippingCartRepositoryTest {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    public void create() {

        // Given
        ProductEntity fishRod = new ProductEntity();
        fishRod.setName("Fishing rod");
        fishRod.setPrice(299.87);
        ProductEntity fishHook = new ProductEntity();
        fishHook.setName("Fishing Hook");
        fishHook.setPrice(1.87);

        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(fishHook);
        productEntities.add(fishRod);

        UserEntity userEntity = new UserEntity();
        userEntity.setName("Piotr");
        userEntity.setShippingAddress("O!polska 15, 01-000 Test");


        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setProductEntities(productEntities);
        shoppingCartEntity.setUserEntity(userEntity);


        // When
        ShoppingCartEntity savedShoppingCartEntity = shoppingCartRepository.save(shoppingCartEntity);

        // Then
        Assertions.assertNotNull(savedShoppingCartEntity, "Saved Entity ist NULL");
    }
}