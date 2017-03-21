package com.yqc.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by yangqc on 2017/3/20.
 */
public interface PersonRepositoryCustom<T>{

    public void sayHello(String name);
}
