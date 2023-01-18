package pl.deptala.piotr.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.onlineshop.api.exceptions.ProductNotFoundException;
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
        LOGGER.info("create(...)" + createdProductModel);
        return "redirect:/products";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws ProductNotFoundException {
        LOGGER.info("read(" + id + ")");
        ProductModel productModel = productService.read(id);
        modelMap.addAttribute("readProduct", productModel);
        LOGGER.info("read(...)" + productModel);
        return "read-product";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws ProductNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        ProductModel readProductModel = productService.read(id);
        modelMap.addAttribute("updateProduct", readProductModel);
        LOGGER.info("updateView() " + readProductModel);
        return "update-product";
    }

    @PostMapping(value = "/update")
    public String update(ProductModel productModel) {
        LOGGER.info("update(" + productModel + ")");
        ProductModel updateProductModel = productService.update(productModel);
        LOGGER.info("update(...)" + updateProductModel);
        return "redirect:/products";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        LOGGER.info("delete(" + id + ")");
        productService.delete(id);
        LOGGER.info("delete(...)");
        return "redirect:/products";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<ProductModel> productModelList = productService.list();
        modelMap.addAttribute("products", productModelList);
        LOGGER.info("list(...) " + productModelList);
        return "products/product-list";
    }

}
