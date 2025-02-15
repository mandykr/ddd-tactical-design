package kitchenpos.products.tobe.domain;

import kitchenpos.products.infra.PurgomalumClient;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Product {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private ProductName name;

    @Embedded
    private ProductPrice price;

    protected Product() {
    }

    public Product(PurgomalumClient purgomalumClient, String name, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = new ProductName(purgomalumClient, name);
        this.price = new ProductPrice(price);
    }

    public UUID getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void changePrice(BigDecimal price) {
        this.price = new ProductPrice(price);
    }
}
