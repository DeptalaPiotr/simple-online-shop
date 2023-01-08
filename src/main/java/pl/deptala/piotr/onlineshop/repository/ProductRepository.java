package pl.deptala.piotr.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
