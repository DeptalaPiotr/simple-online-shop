package pl.deptala.piotr.onlineshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.onlineshop.repository.ProductRepository;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;
import pl.deptala.piotr.onlineshop.service.mapper.ProductMapper;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

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
        LOGGER.info("create("+productModel+")");
        ProductEntity productEntity = productMapper.from(productModel);
        ProductEntity savedEntity = productRepository.save(productEntity);
        ProductModel mappedProductModel = productMapper.from(savedEntity);
        LOGGER.info("create(...) " + mappedProductModel);
        return mappedProductModel;
    }

    // R - read
    public void read() {
        LOGGER.info("read()");
        LOGGER.info("read(...)");
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
