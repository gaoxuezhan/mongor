package com.gaoxz.dao;

import com.gaoxz.domain.Products;

import java.util.List;

/**
 * Created by summer on 2017/5/5.
 */
public interface ProductsDao {

    public void saveProducts(Products user);

    public Products findProductsByProductsName(String userName);

    public long updateProducts(Products user);

    public void deleteProductsById(Long id);

    public List<Products> findAll() ;

    public List<Products> findNewAll() ;

    public List<Products> findDetailByCode(String code) ;

}