package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<Product, Integer>{
    @Query("SELECT product FROM Product product ORDER BY product.name")
    List<Product> findAll();

    @Query("SELECT productType FROM ProductType productType ORDER BY productType.name")
    List<ProductType> findAllProductTypes();

    Optional<Product> findById(int id);

    @Query("SELECT productType FROM ProductType productType where productType.name = :name")
    ProductType findTypeByName(@Param("name") String name);

    @Query("SELECT pMenor FROM Product pMenor where pMenor.price < :coste")
    List<Product> findByPriceLessThan(@Param("coste") Double coste);

    Product findByName(String name);
    Product save(Product p);
}
