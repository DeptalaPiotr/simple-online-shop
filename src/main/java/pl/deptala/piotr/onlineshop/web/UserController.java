package pl.deptala.piotr.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.onlineshop.api.exceptions.UserNotFoundException;
import pl.deptala.piotr.onlineshop.service.UserService;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...)");
        return "create-user";
    }

    @PostMapping()
    public String create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        UserModel createdUserModel = userService.create(userModel);
        LOGGER.info("create(...) " + createdUserModel);
        return "redirect:/users";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(@PathVariable(name = "id") Long id, ModelMap modelMap) throws UserNotFoundException {
        LOGGER.info("read(" + id + ")");
        UserModel readUserModel = userService.read(id);
        modelMap.addAttribute("readUser", readUserModel);
        LOGGER.info("read(...) " + readUserModel);
        return "read-user";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable(name = "id") Long id, ModelMap modelMap) throws UserNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        UserModel readUserToUpdate = userService.read(id);
        modelMap.addAttribute("updateUser", readUserToUpdate);
        LOGGER.info("updateView(...) " + readUserToUpdate);
        return "update-user";
    }

    @PostMapping(value = "/update")
    public String update(UserModel userModel) {
        LOGGER.info("update(" + userModel + ")");
        UserModel updatedUser = userService.update(userModel);
        LOGGER.info("update(...) " + updatedUser);
        return "redirect:/users";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws UserNotFoundException {
        LOGGER.info("delete(" + id + ")");
        userService.delete(id);
        LOGGER.info("delete(...)");
        return "redirect:/users";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<UserModel> userModels = userService.list();
        modelMap.addAttribute("userList", userModels);
        LOGGER.info("list(...) " + userModels);
        return "list-user";
    }
}
