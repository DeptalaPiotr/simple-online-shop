package pl.deptala.piotr.onlineshop.repository.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingCartEntity {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private UserEntity userEntity;
    @OneToMany
    private List<ProductEntity> productEntities;

    public ShoppingCartEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", productEntities=" + productEntities +
                '}';
    }
}
