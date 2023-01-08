package pl.deptala.piotr.onlineshop.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.deptala.piotr.onlineshop.web.model.UserModel;

import java.util.List;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue
    private Long id;
    private UserEntity user;
    private List<ProductEntity> products;

    public ShoppingCartEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
