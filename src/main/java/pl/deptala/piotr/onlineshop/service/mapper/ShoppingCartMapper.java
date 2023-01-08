package pl.deptala.piotr.onlineshop.service.mapper;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartEntity;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCartMapper.class.getName());

    public pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity from(ShoppingCartEntity shoppingCartModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity shoppingCartEntity = modelMapper.map(shoppingCartModel, pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity.class);
        LOGGER.info("from(...)" + shoppingCartEntity);
        return shoppingCartEntity;
    }

    public ShoppingCartEntity from(pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity shoppingCartEntity) {
        LOGGER.info("from(" + shoppingCartEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ShoppingCartEntity shoppingCartModel = modelMapper.map(shoppingCartEntity, ShoppingCartEntity.class);
        LOGGER.info("from(...) = " + shoppingCartModel);
        return shoppingCartModel;
    }

    public List<ShoppingCartEntity> fromEntities(List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> shoppingCartEntities) {
        LOGGER.info("fromEntities(" + shoppingCartEntities + ")");
        List<ShoppingCartEntity> shoppingCartModels = shoppingCartEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + shoppingCartModels);
        return shoppingCartModels;
    }

    public List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> fromModels(List<ShoppingCartEntity> shoppingCartModels) {
        LOGGER.info("fromModels(" + shoppingCartModels + ")");
        List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> shoppingCartEntities = shoppingCartModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + shoppingCartEntities);
        return shoppingCartEntities;
    }
}
