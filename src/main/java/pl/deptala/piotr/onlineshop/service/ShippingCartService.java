package pl.deptala.piotr.onlineshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.onlineshop.repository.ShoppingCartRepository;
import pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity;
import pl.deptala.piotr.onlineshop.service.mapper.ShoppingCartMapper;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartModel;

import java.util.logging.Logger;

@Service
public class ShippingCartService {

    private static final Logger LOGGER = Logger.getLogger(ShippingCartService.class.getName());

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartMapper shoppingCartMapper;

    public ShippingCartService(ShoppingCartRepository shoppingCartRepository, ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    // C - create
    public ShoppingCartModel create(ShoppingCartModel shoppingCartModel) {
        LOGGER.info("create(" + shoppingCartModel + ")");
        ShoppingCartEntity shoppingCartEntity = shoppingCartMapper.from(shoppingCartModel);
        ShoppingCartEntity savedEntity = shoppingCartRepository.save(shoppingCartEntity);
        ShoppingCartModel cartModel = shoppingCartMapper.from(savedEntity);
        LOGGER.info("create(...)" + cartModel);
        return cartModel;
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
