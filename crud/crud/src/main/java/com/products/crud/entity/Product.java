package com.products.crud.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double preco;
    private int quantidade;

    public Product() {}

    public Product(Long id, String name, double preco, int quantidade) {
        this.id = id;
        this.name = name;
        this.preco = preco;
        this.quantidade = quantidade;
    }

}
