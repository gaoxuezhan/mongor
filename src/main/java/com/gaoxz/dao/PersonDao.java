package com.gaoxz.dao;

import com.gaoxz.domain.Person;

import java.util.List;

/**
 * Created by summer on 2017/5/5.
 */
public interface PersonDao {

    public void savePerson(Person user);

    public Person findPersonByPersonName(String userName);

    public long updatePerson(Person user);

    public void deletePersonById(Long id);

    public List<Person> findAllByPersonName(String name) ;

}