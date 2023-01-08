package pl.deptala.piotr.onlineshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void create() {
        // Given
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Fishing rod");
        productEntity.setPrice(299.87);

        // When
        ProductEntity savedEntity = productRepository.save(productEntity);

        // Then
        Assertions.assertNotNull(savedEntity, "Saved Entity ist NULL");

    }

    @Test
    public void createNullEntity(){

        // Given
        ProductEntity productEntity = null;

        // When

        // Then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> productRepository.save(productEntity));
    }

}