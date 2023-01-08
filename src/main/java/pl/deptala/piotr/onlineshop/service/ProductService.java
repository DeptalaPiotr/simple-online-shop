package pl.deptala.piotr.onlineshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.onlineshop.api.exceptions.ProductNotFoundException;
import pl.deptala.piotr.onlineshop.repository.ProductRepository;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;
import pl.deptala.piotr.onlineshop.service.mapper.ProductMapper;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // C - create
    public ProductModel create(ProductModel productModel) {
        LOGGER.info("create(" + productModel + ")");
        ProductEntity productEntity = productMapper.from(productModel);
        ProductEntity savedEntity = productRepository.save(productEntity);
        ProductModel mappedProductModel = productMapper.from(savedEntity);
        LOGGER.info("create(...) " + mappedProductModel);
        return mappedProductModel;
    }

    // R - read
    public ProductModel read(Long id) throws ProductNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity productEntity = optionalProductEntity.orElseThrow(
                () -> new ProductNotFoundException("Product with ID not found " + id));
        ProductModel mappedProductModel = productMapper.from(productEntity);
        LOGGER.info("read(...) " + mappedProductModel);
        return mappedProductModel;
    }

    // U - update
    public ProductModel update(ProductModel updateNote) {
        LOGGER.info("update(" + updateNote + ")");
        ProductEntity productEntity = productMapper.from(updateNote);
        ProductEntity savedEntity = productRepository.save(productEntity);
        ProductModel productModel = productMapper.from(savedEntity);
        LOGGER.info("update(...)" + productModel);
        return productModel;
    }

    // D - delete
    public void delete(Long id) throws ProductNotFoundException {
        LOGGER.info("delete(" + id + ")");
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        ProductEntity productEntity = optionalProductEntity.orElseThrow(
                () -> new ProductNotFoundException("Product with ID not found " + id));
        productRepository.delete(productEntity);
        LOGGER.info("delete(...) " + productEntity);
    }

    // L - list
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
