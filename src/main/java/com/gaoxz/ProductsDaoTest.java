package com.gaoxz;

import com.gaoxz.dao.ProductsDao;
import com.gaoxz.domain.Products;
import com.gaoxz.domain.ProductsEx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsDaoTest {

    @Autowired
    private ProductsDao productsDao;

//    @Test
//    public void testSaveProducts() throws Exception {
//        Products products=new Products();
////        products.setId(2l);
////        products.setProductsName("小明");
////        products.setPassWord("fffooo123");
//        productsDao.saveProducts(products);
//    }

    @Test
    public void findProductsAll(){

        List<Products> products= productsDao.findNewAll();
        for (Products p:products
             ) {
            System.out.println(p.getCode() + "_" + p.getPrice() + "_" + p.getUpdateTime());
        }
    }

    @Test
    public void findProductsByProductsName(){

        ProductsEx products= productsDao.findDetailByCode("ZH9112");
        System.out.println(products.getDetail().toString());
    }

//    @Test
//    public void updateProducts(){
//        Products products=new Products();
////        products.setId(2l);
////        products.setProductsName("天空");
////        products.setPassWord("fffxxxx");
//        productsDao.updateProducts(products);
//    }

//    @Test
//    public void deleteProductsById(){
//        productsDao.deleteProductsById(1l);
//    }

}