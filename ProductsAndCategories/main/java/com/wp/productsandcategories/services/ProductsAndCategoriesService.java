package com.wp.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wp.productsandcategories.models.Category;
import com.wp.productsandcategories.models.Product;
import com.wp.productsandcategories.repositories.CategoryRepository;
import com.wp.productsandcategories.repositories.ProductRepository;

@Service
public class ProductsAndCategoriesService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductsAndCategoriesService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<Product> findAllByCategory(Category c) {
		return productRepository.findAllByCategories(c);
	}
	
	public List<Product> findByCategoryNotIn(Category c) {
		return productRepository.findByCategoriesNotContains(c);
	}
	
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
	
	public List<Category> findAllByProduct(Product p) {
		return categoryRepository.findAllByProducts(p);
	}
	
	public List<Category> findByProductNotIn(Product p) {
		return categoryRepository.findByProductsNotContains(p);
	}
	
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public Category addProductToCategory(Long categoryId, Long productId) {
        Category thisCategory = findCategory(categoryId);
        Product thisProduct = findProduct(productId);
        thisCategory.getProducts().add(thisProduct);
        return categoryRepository.save(thisCategory);
    }
    
    public Product addCategoryToProduct(Long productId, Long categoryId) {
        Product thisProduct = findProduct(productId);
        Category thisCategory = findCategory(categoryId);
        thisProduct.getCategories().add(thisCategory);
        return productRepository.save(thisProduct);
    }
    
    
}
