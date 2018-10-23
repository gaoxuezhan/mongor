package com.gaoxz.dao.impl;

import com.gaoxz.dao.PersonDao;
import com.gaoxz.domain.Person;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by summer on 2017/5/5.
 */
@Component
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param test
     */
    @Override
    public void savePerson(Person test) {
        mongoTemplate.save(test);
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    @Override
    public Person findPersonByPersonName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        Person test =  mongoTemplate.findOne(query , Person.class);
        return test;
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    @Override
    public List<Person> findAllByPersonName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        List<Person> people=  mongoTemplate.find(query, Person.class);
        return people;
    }

    /**
     * 更新对象
     * @param test
     */
    @Override
    public long updatePerson(Person test) {
        Query query=new Query(Criteria.where("name").is(test.getName()));
        Update update= new Update().set("age", "18").set("sex", "man");
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query,update,Person.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,Person.class);
        if(result!=null)
            return result.getMatchedCount();
        else
            return 0;
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deletePersonById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Person.class);
    }
}