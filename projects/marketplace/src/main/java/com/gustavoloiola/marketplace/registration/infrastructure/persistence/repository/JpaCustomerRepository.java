package com.gustavoloiola.marketplace.registration.infrastructure.persistence.repository;

import com.gustavoloiola.marketplace.registration.domain.Customer;
import com.gustavoloiola.marketplace.registration.domain.CustomerRepository;

import java.util.List;

public class JpaCustomerRepository implements CustomerRepository {

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
