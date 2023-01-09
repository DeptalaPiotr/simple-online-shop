package pl.deptala.piotr.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.onlineshop.service.ProductService;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "create-product";
    }

    @PostMapping
    public String create(ProductModel productModel) {
        LOGGER.info("create(" + productModel + ")");
        ProductModel createdProductModel = productService.create(productModel);
        LOGGER.info("create(...)"+createdProductModel);
        return "redirect:/products";
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
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<ProductModel> productModelList = productService.list();
        modelMap.addAttribute("products", productModelList);
        LOGGER.info("list(...) " + productModelList);
        return "product-list";
    }

}
