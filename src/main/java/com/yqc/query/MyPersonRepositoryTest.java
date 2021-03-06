package com.yqc.query;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqc on 2017/3/14.
 */
@Component
public class MyPersonRepositoryTest {

    @Autowired
    MyPersonRepository myPersonRepository;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    MongoRepository mongoRepository;

    public void test() {
        List<Person> personList = myPersonRepository.findAll();
        System.out.println(mongoRepository);
        /*
         * 新增
         */
        List<Person> insertPersonList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            insertPersonList.add(new Person(("my_yangqc_" + i), i));
        }
        myPersonRepository.insert(insertPersonList);
/**
 * 测试查询
 */
//        personList = myPersonRepository.findByThePersonName("yangqc");
//        personList = myPersonRepository.sayHello("yangqc_1");
//        personList=myPersonRepository.findByNameAndAge("yangqc_1",1);
//        personList = myPersonRepository.findByNameOrNameOrName("yangqc_1", "yangqc_2","yangqc_8");
//        personList = myPersonRepository.findByNameOrAge("yangqc_1", 9);
//        myPersonRepository.deleteByAgeBetween(0, 3);
//        myPersonRepository.findByNameLike("_");


      /*  List<MyPerson> personList = myPersonRepository.sayHello("my_yangqc_1");
        for (MyPerson person : personList) {
            System.out.println(person);
        }*/
    }

    public void findByCount() {
        System.out.println();
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        MyPersonRepositoryTest myPersonRepositoryTest = annotationContext.getBean("myPersonRepositoryTest", MyPersonRepositoryTest.class);
//        myPersonRepositoryTest.test();
//        myPersonRepositoryTest.findByCount();
        System.out.println(myPersonRepositoryTest.mongoOperations.getCollectionName(Person.class));
    }
}
