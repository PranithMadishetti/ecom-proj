package com.telusko.ecom_proj.repo;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    // public List<Product> findByBrand(String brand); this method can be declared explicitly by the user to search for any other fields from the database.

    // if a user can write a customised queries we can make use of JPQL - JPA Query language
    @Query("SELECT p from Product p WHERE "+
        "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")   // this tag is used to explicit declare the SQL query from the database



     List<Product> searchProducts(String keyword);
}
