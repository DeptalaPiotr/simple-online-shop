package pl.deptala.piotr.onlineshop.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.deptala.piotr.onlineshop.web.model.ShoppingCartEntity;

public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private ShoppingCartEntity shoppingCart;
    private String shippingAddress;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, ShoppingCartEntity shoppingCart, String shippingAddress) {
        this.id = id;
        this.name = name;
        this.shoppingCart = shoppingCart;
        this.shippingAddress = shippingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCartEntity getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartEntity shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}
