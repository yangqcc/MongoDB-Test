package com.yqc.repository;

import com.yqc.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface MyEntityRepository extends MongoRepository<Person, String>, MyEntityRepositoryCustom {

}
