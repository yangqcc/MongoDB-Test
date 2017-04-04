package com.yqc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by yangqc on 2017/4/4.
 */
@Component
public class Test {

    @Autowired
    MyEntityRepository personRepository;

    /**
     * 测试{@link MyEntityRepositoryCustom#saveTenTimes()}方法
     */
    public void testSaveMethod() {
        personRepository.saveTenTimes();
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.repository");
        Test test = annotationContext.getBean("test", Test.class);
        test.testSaveMethod();
    }
}
