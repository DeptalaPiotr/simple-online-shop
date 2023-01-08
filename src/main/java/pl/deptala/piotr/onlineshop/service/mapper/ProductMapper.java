package pl.deptala.piotr.onlineshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.onlineshop.repository.entity.ProductEntity;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private static final Logger LOGGER = Logger.getLogger(ProductMapper.class.getName());

    public ProductEntity from(ProductModel productModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        ProductEntity productEntity = modelMapper.map(productModel, ProductEntity.class);
        LOGGER.info("from(...)" + productEntity);
        return productEntity;
    }

    public ProductModel from(ProductEntity productEntity) {
        LOGGER.info("from(" + productEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ProductModel productModel = modelMapper.map(productEntity,ProductModel.class);
        LOGGER.info("from(...) = " + productModel);
        return productModel;
    }

    public List<ProductModel> fromEntities(List<ProductEntity> productEntities) {
        LOGGER.info("fromEntities(" + productEntities + ")");
        List<ProductModel> productModels = productEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + productModels);
        return productModels;
    }

    public List<ProductEntity> fromModels(List<ProductModel> productModels) {
        LOGGER.info("fromModels(" + productModels + ")");
        List<ProductEntity> productEntities = productModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + productEntities);
        return productEntities;
    }
}
