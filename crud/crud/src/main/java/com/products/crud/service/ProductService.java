package com.products.crud.service;

import com.products.crud.entity.Product;
import com.products.crud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product findProductByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product productToUpdate = repository.findById(id).orElse(null);

        if (productToUpdate == null) {
            return null;
        }

        productToUpdate.setName(product.getName());
        productToUpdate.setPreco(product.getPreco());
        productToUpdate.setQuantidade(product.getQuantidade());

        return repository.save(productToUpdate);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
