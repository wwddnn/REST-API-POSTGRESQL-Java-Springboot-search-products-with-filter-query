package com.commerce.springboot.repository;

import com.commerce.springboot.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // JPQL to search by name with filter
    @Query("SELECT obj " +
            "FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name,  '%' ) )")
    Page<Product> searchByName(String name, Pageable pageable);
}
