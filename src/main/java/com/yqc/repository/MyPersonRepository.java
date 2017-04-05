package com.yqc.repository;

import com.yqc.Person;
import com.yqc.repository.MyEntityRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yangqc on 2017/4/5.
 */
public interface MyPersonRepository extends MongoRepository<Person, String>, MyEntityRepositoryCustom<Person> {
}
