package pl.deptala.piotr.onlineshop.web.model;


import java.util.List;

public class ShoppingCartModel {

    private Long id;
    private UserModel user;
    private List<ProductModel> productModels;

    public ShoppingCartModel() {
    }

    public ShoppingCartModel(Long id, UserModel user, List<ProductModel> productModels) {
        this.id = id;
        this.user = user;
        this.productModels = productModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<ProductModel> getProductModels() {
        return productModels;
    }

    public void setProductModels(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    @Override
    public String toString() {
        return "ShoppingCartModel{" +
                "id=" + id +
                ", user=" + user +
                ", productModels=" + productModels +
                '}';
    }
}
