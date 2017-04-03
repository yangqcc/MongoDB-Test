package com.yqc.query;

import com.yqc.MyPerson;
import com.yqc.Person;
import com.yqc.Point;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by yangqc on 2017/3/14.
 */
public interface MyPersonRepository extends MongoRepository<Person, String> {

    @Query("{'sayHello':?0}")
    List<Person> findByThePersonName(String name);

//    @Query(fields = "{'age':1,'favorite':1}")
//    List<Cat> sayHello(String sayHello);

    List<Person> findByNameAndAge(String name, int age);

    List<Person> findByNameOrNameOrName(String name1, String name2, String name3);

    List<Person> findByNameOrAge(String name, int age);

    List<Person> deleteByAgeBetween(int age1, int age2);

    List<Person> findByNameLike(String name);

    List<MyPerson> findByName(String name);

//    int f();

}
