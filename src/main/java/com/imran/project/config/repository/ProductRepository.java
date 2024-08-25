package com.imran.project.config.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imran.project.config.models.Product;


public interface ProductRepository  extends JpaRepository<Product, Long>
{
	@Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR p.productCode LIKE %?1%"
            )
	public List<Product> findByKeyword(String keyword);

	public Product findByProductCode(String productCode);
}
