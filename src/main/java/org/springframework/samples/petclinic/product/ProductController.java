package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    private static final String VISTA="products/createOrUpdateProductForm";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("productTypes")
    public Collection<ProductType> populatePetTypes() {
        return this.productService.getAllProductTypes();
    }

    @GetMapping(value="/create")
    public String initCreationForm(ModelMap model) {
        Product p = new Product();
        model.put("product", p);
        return VISTA;
    }

    @PostMapping(value="/create")
    public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.put("product", product);
            model.put("productTypes", productService.getAllProductTypes());
            return VISTA;
        } else{
                this.productService.save(product);
                model.put("message","Product succesfully saved!");
            }
            return "welcome";
   }

}
