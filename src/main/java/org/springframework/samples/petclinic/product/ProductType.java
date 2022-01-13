package org.springframework.samples.petclinic.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "product_type", uniqueConstraints=
    @UniqueConstraint(columnNames = {"name"}))
public class ProductType extends BaseEntity {

    @NotNull
    @Size(min=3,max=50)
    String name;
}
