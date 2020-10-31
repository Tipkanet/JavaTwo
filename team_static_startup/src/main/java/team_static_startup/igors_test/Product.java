package team_static_startup.igors_test;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private final String productName;
    private final String productDescription;
    private final BigDecimal price;

    public Product(String productName, String productDescription, BigDecimal price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return productName;
    }

    public String getDescription() {
        return productDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productDescription, product.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDescription);
    }
}
