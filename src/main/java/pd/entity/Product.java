package pd.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    private int pid;
    private String pname;
    private float price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private List<Orders> listOfOrders;
    private int quantity;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
