package pl.deptala.piotr.onlineshop.service.mapper;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartModel;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCartMapper.class.getName());

    public pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity from(ShoppingCartModel shoppingCartModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity shoppingCartEntity = modelMapper.map(shoppingCartModel, pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity.class);
        LOGGER.info("from(...)" + shoppingCartEntity);
        return shoppingCartEntity;
    }

    public ShoppingCartModel from(pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity shoppingCartEntity) {
        LOGGER.info("from(" + shoppingCartEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ShoppingCartModel shoppingCartModel = modelMapper.map(shoppingCartEntity, ShoppingCartModel.class);
        LOGGER.info("from(...) = " + shoppingCartModel);
        return shoppingCartModel;
    }

    public List<ShoppingCartModel> fromEntities(List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> shoppingCartEntities) {
        LOGGER.info("fromEntities(" + shoppingCartEntities + ")");
        List<ShoppingCartModel> shoppingCartModels = shoppingCartEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + shoppingCartModels);
        return shoppingCartModels;
    }

    public List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> fromModels(List<ShoppingCartModel> shoppingCartModels) {
        LOGGER.info("fromModels(" + shoppingCartModels + ")");
        List<pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity> shoppingCartEntities = shoppingCartModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + shoppingCartEntities);
        return shoppingCartEntities;
    }
}
