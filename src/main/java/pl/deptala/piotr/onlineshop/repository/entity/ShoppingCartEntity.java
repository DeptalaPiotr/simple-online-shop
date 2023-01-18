package pl.deptala.piotr.onlineshop.repository.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue
    private Long id;
    //    @ManyToOne()
//    private UserEntity userEntity;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntities = new ArrayList<>();

    public ShoppingCartEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public UserEntity getUserEntity() {
//        return userEntity;
//    }
//
//    public void setUserEntity(UserEntity userEntity) {
//        this.userEntity = userEntity;
//    }

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
//                ", userEntity=" + userEntity +
                ", productEntities=" + productEntities +
                '}';
    }
}
