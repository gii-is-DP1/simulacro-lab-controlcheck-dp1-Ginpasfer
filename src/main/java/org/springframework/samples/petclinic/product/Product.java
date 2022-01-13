package org.springframework.samples.petclinic.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter

public class Product extends BaseEntity {

    @NotNull
    @Size(min=3,max=50)
    String name;

    @NotNull
    @Min(0)
    double price;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    ProductType productType;
}
