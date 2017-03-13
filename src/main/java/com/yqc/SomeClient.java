package com.yqc;

import com.yqc.PersonRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
public class SomeClient {

    private PersonRepository repository;

    public void doSomething() {
        List<Person> persons = repository.findByLastName("qicheng");
    }
}
