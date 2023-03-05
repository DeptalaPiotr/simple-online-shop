package pl.deptala.piotr.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.onlineshop.api.exceptions.ShoppingNotFoundException;
import pl.deptala.piotr.onlineshop.service.ShoppingCartService;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartController {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCartController.class.getName());

    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...)");
        return "shopping-cart/create-shopping-cart";
    }

    @PostMapping
    public String create(ShoppingCartModel shoppingCartModel) {
        LOGGER.info("create(" + shoppingCartModel + ")");
        ShoppingCartModel createShoppingCart = shoppingCartService.create(shoppingCartModel);
        LOGGER.info("create(...) " + createShoppingCart);
        return "redirect:/shoppingCart";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws ShoppingNotFoundException {
        LOGGER.info("read(" + id + ")");
        ShoppingCartModel readShoppingCartModel = shoppingCartService.read(id);
        modelMap.addAttribute("readCart", readShoppingCartModel);
        LOGGER.info("read(...)" + readShoppingCartModel);
        return "shopping-cart/read-shopping-cart.html";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws ShoppingNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        ShoppingCartModel readShoppingCartModel = shoppingCartService.read(id);
        modelMap.addAttribute("updateProduct", readShoppingCartModel);
        LOGGER.info("updateView() " + readShoppingCartModel);
        return "shopping-cart/update-shopping-cart";
    }

    @PostMapping(value = "/update")
    public String update(ShoppingCartModel shoppingCartModel) {
        LOGGER.info("update(" + shoppingCartModel + ")");
        ShoppingCartModel updateShoppingCartModel = shoppingCartService.update(shoppingCartModel);
        LOGGER.info("update(...)" + updateShoppingCartModel);
        return "redirect:/shoppingCart";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws ShoppingNotFoundException {
        LOGGER.info("delete(" + id + ")");
       shoppingCartService.delete(id);
        LOGGER.info("delete(...)");
        return "redirect:/shoppingCart";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<ShoppingCartModel> listCarts = shoppingCartService.list();
        modelMap.addAttribute("listCarts", listCarts);
        LOGGER.info("list(...) " + listCarts);
        return "shopping-cart/shopping-cart-list";
    }
}
