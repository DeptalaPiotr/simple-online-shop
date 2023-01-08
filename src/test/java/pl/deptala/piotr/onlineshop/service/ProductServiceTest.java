package pl.deptala.piotr.onlineshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void create() {
// Given
        ProductModel productModel = new ProductModel();

// When
        ProductModel createdProductModel = productService.create(productModel);

// Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdProductModel, "createdNoteModel is NULL"),
                () -> Assertions.assertNotNull(createdProductModel.getId(), "createdNoteModel ID is NULL"));
    }
}