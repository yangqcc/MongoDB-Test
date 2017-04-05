package com.yqc.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by yangqc on 2017/3/20.
 */
@NoRepositoryBean
public interface MyEntityRepositoryCustom<T> {

    void saveTenTimes();
}
