package com.wp.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wp.productsandcategories.models.Category;
import com.wp.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>  {
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}
