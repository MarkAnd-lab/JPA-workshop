package se.lexicon.mark.JPAworkshop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductOrderId;

    private LocalDateTime orderDateTime;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            orphanRemoval = true, mappedBy = "productOrder", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private AppUser customer;

    public ProductOrder() {
    }

    public ProductOrder(LocalDateTime orderDateTime, AppUser customer) {
        setOrderItems(new ArrayList<>());
        setOrderDateTime(orderDateTime);
        setCustomer(customer);
    }

    public ProductOrder(LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this(orderDateTime, customer);
        setOrderItems(orderItems);

    }

    public ProductOrder(int productOrderId, LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this(orderDateTime, orderItems, customer);
        ProductOrderId = productOrderId;

    }

    /**
     * Convenience method. <br>
     * Adds in a bidirectional way <br>
     * Adds orderItem to ProductOrder and ProductOrder to OrderItem.
     * @param orderItem
     */
    public void addOrderItem(OrderItem orderItem){

        if (orderItems == null){
            orderItems = new ArrayList<>();
        }

        orderItems.add(orderItem);
        orderItem.setProductOrder(this);
    }

    /**
     * Convenience method. <br>
     * removes in a bidirectional way <br>
     * removes orderItem from ProductOrder and ProductOrder from OrderItem.
     * @param orderItem
     */
    public void removeOrderItem(OrderItem orderItem){

        if (orderItems == null){
            orderItems = new ArrayList<>();
        }

        if(orderItem == null) throw new IllegalArgumentException("orderItem was " + null);

        orderItem.setProductOrder(null);
        orderItems.remove(orderItem);
    }

    public int getProductOrderId() {
        return ProductOrderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return ProductOrderId == that.ProductOrderId &&
                Objects.equals(orderDateTime, that.orderDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductOrderId, orderDateTime);
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "ProductOrderId=" + ProductOrderId +
                ", orderDateTime=" + orderDateTime +
                ", customer=" + customer +
                '}';
    }
}
