package com.wp.productsandcategories.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wp.productsandcategories.models.Category;
import com.wp.productsandcategories.models.Product;
import com.wp.productsandcategories.services.ProductsAndCategoriesService;

public class ProductsAndCategoriesApi {
	private final ProductsAndCategoriesService productsAndCategoriesService;
	public ProductsAndCategoriesApi (ProductsAndCategoriesService productsAndCategoriesService) {
		this.productsAndCategoriesService = productsAndCategoriesService;
	}
	
    @RequestMapping(value="/api/products", method=RequestMethod.POST)
    public Product createProduct(@RequestParam(value="name") String name) {
        Product product = new Product(name);
        return productsAndCategoriesService.createProduct(product);
    }
    
    @RequestMapping(value="/api/categories", method=RequestMethod.POST)
    public Category createCategory(@RequestParam(value="name") String name) {
        Category category = new Category(name);
        return productsAndCategoriesService.createCategory(category);
    }
	
	@RequestMapping("/api/products/{id}")
	public Product showProduct(@PathVariable("id") Long id) {
		Product product = productsAndCategoriesService.findProduct(id);		
		return product;
	}
	
    @RequestMapping("/api/products/{id}")
    public List<Category> getAllInCategory(@PathVariable("id") Long id) {
		Product product = productsAndCategoriesService.findProduct(id);
        return productsAndCategoriesService.findAllByProduct(product);
    }
    
    @RequestMapping("/api/products/{id}")
    public List<Category> getAllNotInCategory(@PathVariable("id") Long id) {
		Product product = productsAndCategoriesService.findProduct(id);
        return productsAndCategoriesService.findByProductNotIn(product);
    }
	
	@RequestMapping("/api/categories/{id}")
	public Category showCategory(@PathVariable("id") Long id) {
		Category category = productsAndCategoriesService.findCategory(id);
		return category;
	}	
	
    @RequestMapping("/api/products/{id}")
    public List<Product> getAllInProduct(@PathVariable("id") Long id) {
		Category category = productsAndCategoriesService.findCategory(id);
        return productsAndCategoriesService.findAllByCategory(category);
    }
    
    @RequestMapping("/api/products/{id}")
    public List<Product> getAllNotInProduct(@PathVariable("id") Long id) {
		Category category = productsAndCategoriesService.findCategory(id);
        return productsAndCategoriesService.findByCategoryNotIn(category);
    }
    
    @RequestMapping(value="/api/categories/add", method=RequestMethod.POST)
    public Category addProduct(@RequestParam(value="categoryId") Long categoryId, @RequestParam(value="productId") Long productId) {
        return productsAndCategoriesService.addProductToCategory(categoryId, productId);
    }
    
    @RequestMapping(value="/api/categories/add", method=RequestMethod.POST)
    public Product addCategory(@RequestParam(value="categoryId") Long categoryId, @RequestParam(value="productId") Long productId) {
        return productsAndCategoriesService.addCategoryToProduct(categoryId, productId);
    }
}
