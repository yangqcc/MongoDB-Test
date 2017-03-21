package com.yqc.repository;

import com.yqc.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, String>, PersonRepositoryCustom<Person> {

 /*   public List<Person> findByName(String name, Pageable pageable);

    *//**
     * 查询年龄大于指定数字的人
     *
     * @param age
     * @return
     *//*
    public List<Person> findByAgeAfter(int age);

    public List<Person> findByAgeGreaterThanEqual(int age);*/
}
