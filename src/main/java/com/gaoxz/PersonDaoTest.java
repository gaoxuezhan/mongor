package com.gaoxz;

import com.gaoxz.dao.PersonDao;
import com.gaoxz.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testSavePerson() throws Exception {
        Person person=new Person();
        person.setName("gaoxz");
        person.setAge("18");
        person.setSex("man");
        personDao.savePerson(person);
    }

    @Test
    public void findPersonByPersonName(){
       Person person= personDao.findPersonByPersonName("test");
       System.out.println("person is "+person);
       System.out.println("person'name is "+person.getName());
       System.out.println("person'age is "+person.getAge());
       System.out.println("person'sex is "+person.getSex());

        List<Person> list= personDao.findAllByPersonName("test");

        for (Person p:list ) {
            System.out.println("person is "+ p);
            System.out.println("person'name is "+p.getName());
            System.out.println("person'age is "+p.getAge());
            System.out.println("person'sex is "+p.getSex());

            p.setSex("dog");
            p.setAge("cat");
            this.personDao.savePerson(p);
        }


    }

//    @Test
//    public void updatePerson(){
//        Person person=new Person();
//        person.setId(2l);
//        person.setPersonName("天空");
//        person.setPassWord("fffxxxx");
//        personDao.updatePerson(person);
//    }
//
//    @Test
//    public void deletePersonById(){
//        personDao.deletePersonById(1l);
//    }

}