package com.wp.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wp.productsandcategories.models.Category;
import com.wp.productsandcategories.models.Product;
import com.wp.productsandcategories.services.ProductsAndCategoriesService;

@Controller
public class ProductsAndCategoriesController {
	private final ProductsAndCategoriesService productsAndCategoriesService;
	
	public ProductsAndCategoriesController(ProductsAndCategoriesService productsAndCategoriesService) {
		this.productsAndCategoriesService = productsAndCategoriesService;
	}
	
    @RequestMapping("/products/new")
    public String productsNew(@ModelAttribute("product") Product product) {
        return "/productsandcategories/product-new.jsp";
    }
    
    @RequestMapping("/categories/new")
    public String categoriesNew(@ModelAttribute("category") Category category) {
        return "/productsandcategories/categories-new.jsp";
    }
    
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/productsandcategories/product-new.jsp";
        } else {
            productsAndCategoriesService.createProduct(product);
            return "redirect:/products/new";
        }
    }
    
    @RequestMapping(value="/categories", method=RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/productsandcategories/categories-new.jsp";
        } else {
            productsAndCategoriesService.createCategory(category);
            return "redirect:/categories/new";
        }
    }
    
    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
    	Product product = productsAndCategoriesService.findProduct(id);
    	List<Category> inCategories = productsAndCategoriesService.findAllByProduct(product);
    	List<Category> outCategories = productsAndCategoriesService.findByProductNotIn(product);
		model.addAttribute("product", product);
		model.addAttribute("inCategories", inCategories);
		model.addAttribute("outCategories", outCategories);
    	return "/productsandcategories/products.jsp";
    }
    
    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
    	Category category = productsAndCategoriesService.findCategory(id);
    	List<Product> inProducts = productsAndCategoriesService.findAllByCategory(category);
    	List<Product> outProducts = productsAndCategoriesService.findByCategoryNotIn(category);
		model.addAttribute("category", category);
		model.addAttribute("inProducts", inProducts);
		model.addAttribute("outProducts", outProducts);
    	return "/productsandcategories/categories.jsp";
    }   
    
    @RequestMapping(value="/products/add", method=RequestMethod.POST)
    public String addCategoryToProduct(@RequestParam("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
        productsAndCategoriesService.addCategoryToProduct(productId, categoryId);
        return "redirect:/products/" + productId;
    }
    
    @RequestMapping(value="/categories/add", method=RequestMethod.POST)
    public String addProductToCategory(@RequestParam("productId") Long productId, @RequestParam("categoryId") Long categoryId) {
        productsAndCategoriesService.addProductToCategory(categoryId, productId);
        return "redirect:/categories/" + categoryId;
    }
}

