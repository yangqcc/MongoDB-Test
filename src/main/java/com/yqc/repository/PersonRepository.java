package com.yqc.repository;

import com.yqc.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
