package com.wp.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wp.productsandcategories.models.Category;
import com.wp.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>  {
    List<Product> findAllByCategories(Category category);
    List<Product> findByCategoriesNotContains(Category category);

}
