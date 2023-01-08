package pl.deptala.piotr.onlineshop.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.deptala.piotr.onlineshop.web.model.ProductModel;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.List;

public class ShoppingCartEntity {

    @Id
    @GeneratedValue
    private Long id;
    private UserModel user;
    private List<ProductEntity> products;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Long id, UserModel user, List<ProductEntity> products) {
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

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
