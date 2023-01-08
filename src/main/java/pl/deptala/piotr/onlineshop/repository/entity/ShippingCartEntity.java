package pl.deptala.piotr.onlineshop.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.List;

public class ShippingCartEntity {

    @Id
    @GeneratedValue
    private Long id;
    private UserModel user;
    private List<ProductModel> products;

    public ShippingCartEntity() {
    }

    public ShippingCartEntity(Long id, UserModel user, List<ProductModel> products) {
        this.id = id;
        this.user = user;
        this.products = products;
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

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCartModel{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
