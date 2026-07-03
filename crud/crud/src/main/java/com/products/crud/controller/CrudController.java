package com.products.crud.controller;

import com.products.crud.entity.Product;
import com.products.crud.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class CrudController {

   private final ProductService service;

   public CrudController(ProductService service) {
       this.service = service;
   }

   @GetMapping
   public List<Product> listAll() {
       return service.findAllProducts();
   }

   @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
       return service.findProductByID(id);
   }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping
    public Product put(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @DeleteMapping
    public Product delete(@RequestBody Product product) {
        return service.saveProduct(product);
    }

}
