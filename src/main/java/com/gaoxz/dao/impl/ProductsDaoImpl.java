package com.gaoxz.dao.impl;

import com.gaoxz.dao.ProductsDao;
import com.gaoxz.domain.Products;
import com.gaoxz.domain.ProductsEx;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.client.result.UpdateResult;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by summer on 2017/5/5.
 */
@Component
public class ProductsDaoImpl implements ProductsDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param test
     */
    @Override
    public void saveProducts(Products test) {
        mongoTemplate.save(test);
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    @Override
    public Products findProductsByProductsName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        Products test =  mongoTemplate.findOne(query , Products.class);
        return test;
    }

    /**
     * 根据用户名查询对象
     * @param
     * @return
     */
    @Override
    public List<Products> findAll() {
        List<Products> people=  mongoTemplate.findAll(Products.class);
        return people;
    }


    @Override
    public List<Products> findNewAll() {
        List<Products> listNewAll =  mongoTemplate.findAll(Products.class);
        Map<String, Products> mapNewAll = new HashMap<String, Products>();

        for (Products p :
             listNewAll) {

            if (mapNewAll.containsKey(p.getCode())){
                Products king = mapNewAll.get(p.getCode());
                if(king.getUpdateTime().toString().compareTo(p.getUpdateTime().toString()) < 0){
                    mapNewAll.put(p.getCode(),p);
                }
            }else{
                mapNewAll.put(p.getCode(),p);
            }

        }

        List<Products> result = new ArrayList<Products>();
        result.addAll(mapNewAll.values());

        return result;
    }

    @Override
    public ProductsEx findDetailByCode(String code){

        Query query=new Query(Criteria.where("code").is(code));
        Sort.Direction direction=false?Sort.Direction.ASC:Sort.Direction.DESC;
        query.with(new Sort(direction,"updateTime"));
        List<Products> people=  mongoTemplate.find(query, Products.class);

        ProductsEx result = new ProductsEx();
        Map<String, String> detail = new LinkedHashMap<String, String>();
        result.setDetail(detail);

        for (Products p:
             people) {
            if(StringUtils.isEmpty(result.getTarget())){
                result.setTarget(p);
            }

            detail.put(p.getUpdateTime(), p.getPrice());

        }

//        Query query=new Query(Criteria.where("name").is(name));
//        List<String> result = mongoTemplate.getCollection("asdf").distinct("updateTime");

//        CommandResult result = mongoTemplate.executeCommand("");
//        CommandResult result = mongoTemplate.executeCommand("{distinct:'tuser', key:'sex'}");

        return result;
    }

    /**
     * 更新对象
     * @param test
     */
    @Override
    public long updateProducts(Products test) {
//        Query query=new Query(Criteria.where("name").is(test.getName()));
//        Update update= new Update().set("age", "18").set("sex", "man");
//        //更新查询返回结果集的第一条
//        UpdateResult result = mongoTemplate.updateFirst(query,update,Products.class);
//        //更新查询返回结果集的所有
//        // mongoTemplate.updateMulti(query,update,Products.class);
//        if(result!=null)
//            return result.getMatchedCount();
//        else
            return 0;
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteProductsById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Products.class);
    }

}