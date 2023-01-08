package pl.deptala.piotr.onlineshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartEntity;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShoppingCartMapperTest {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    void fromShoppingCartModel() {

        // Given
        UserModel piotr = new UserModel();
        piotr.setName("Piotr");

        ProductModel spoon = new ProductModel();
        spoon.setName("Spoon");
        spoon.setPrice(22.47);

        ProductModel knife = new ProductModel();
        knife.setName("Knife");
        knife.setPrice(12.66);

        List<ProductModel> productModels = new ArrayList<>();
        productModels.add(spoon);
        productModels.add(knife);

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
//        shoppingCartModel.setUser(piotr);
//        shoppingCartModel.setProducts(productModels);

        // When
        pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity mappedShoppingCartEntity = shoppingCartMapper.from(shoppingCartEntity);

        // Then
        Assertions.assertNotNull(mappedShoppingCartEntity, "mappedEntity is NULL");
    }

    @Test
    void testFrom() {
    }

    @Test
    void fromEntities() {
    }

    @Test
    void fromModels() {
    }
}