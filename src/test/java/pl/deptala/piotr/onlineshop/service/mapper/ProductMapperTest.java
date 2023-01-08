package pl.deptala.piotr.onlineshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void fromModel() {

        // Given
        ProductModel productModel = new ProductModel();
        productModel.setName("iPhone");
        productModel.setPrice(1299.99);

        // When
        ProductEntity mappedProductEntity = productMapper.from(productModel);

        // Then
        Assertions.assertNotNull(mappedProductEntity, "Saved Entity ist NULL");
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