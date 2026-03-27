package com.employee.practice.Repository;

import com.employee.practice.Entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameOrderByPrice(String name);

    List<Product> findByOrderByPrice();

    List<Product> findBy(Sort sort₹);

    List<Product> findByNameContaining(String name, Pageable pageable);
}
