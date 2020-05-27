package se.lexicon.mark.JPAworkshop.entity;

import java.util.Objects;

public class Product {

    private int productId;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public Product(int productId, String name, double price) {
        this(name, price);
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
