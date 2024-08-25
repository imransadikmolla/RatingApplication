package com.imran.project.config.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.project.config.models.Product;
import com.imran.project.config.models.Status;
import com.imran.project.config.repository.ProductRepository;
import com.imran.project.config.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> fetchProductByProductNameOrBrandOrProductCode(String query) {
		if (query != null) {
			return productRepository.findByKeyword(query);
		}
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		System.out.println(product.toString());
		return this.productRepository.save(product);
	}

	public Product showSingleProduct(Long productId) {
		return this.productRepository.findById(productId).orElse(null);
	}

	public Product findByProductCode(String productCode) {
		return this.productRepository.findByProductCode(productCode);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Status addProduct(@Valid Product product) {
		List<Product> products = productRepository.findAll();
		for (Product prod : products) {

			if (prod.equals(product)) {
				System.out.println("Product Already exists!");
				return Status.PRODUCT_ALREADY_EXISTS;
			}
		}
		productRepository.save(product);
		return Status.SUCCESS;
	}

}
