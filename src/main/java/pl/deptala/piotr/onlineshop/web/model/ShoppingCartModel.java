package pl.deptala.piotr.onlineshop.web.model;

public class ShoppingCartModel {

    private Long id;
    private UserModel user;

    public ShoppingCartModel() {
    }

    public ShoppingCartModel(Long id, UserModel user) {
        this.id = id;
        this.user = user;
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

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
