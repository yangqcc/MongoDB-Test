package com.yqc;

import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface PersonRepository extends Repository<Person, String> {
    List<Person> findByLastName(String lastName);
}
