package pl.deptala.piotr.onlineshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.onlineshop.api.exceptions.ShoppingNotFoundException;
import pl.deptala.piotr.onlineshop.repository.ShoppingCartRepository;
import pl.deptala.piotr.onlineshop.repository.entity.ShoppingCartEntity;
import pl.deptala.piotr.onlineshop.service.mapper.ShoppingCartMapper;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ShoppingCartService {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCartService.class.getName());

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ShoppingCartMapper shoppingCartMapper) {
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
    public ShoppingCartModel read(Long id) throws ShoppingNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<ShoppingCartEntity> optionalShoppingCartEntity = shoppingCartRepository.findById(id);
        ShoppingCartEntity shoppingCartEntity = optionalShoppingCartEntity.orElseThrow(
                () -> new ShoppingNotFoundException("Shopping Cart with ID: " + id + " not found"));
        ShoppingCartModel cartModel = shoppingCartMapper.from(shoppingCartEntity);
        LOGGER.info("read(...)" + cartModel);
        return cartModel;
    }

    // U - update
    public ShoppingCartModel update(ShoppingCartModel shoppingCartModel) {
        LOGGER.info("update(" + shoppingCartModel + ")");
        ShoppingCartEntity shoppingCartEntity = shoppingCartMapper.from(shoppingCartModel);
        ShoppingCartEntity savedEntity = shoppingCartRepository.save(shoppingCartEntity);
        ShoppingCartModel updateModel = shoppingCartMapper.from(savedEntity);
        LOGGER.info("update(...)" + updateModel);
        return updateModel;
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
