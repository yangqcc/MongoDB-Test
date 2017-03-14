package com.yqc.query;

import com.yqc.Person;
import com.yqc.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    public void test() {
        List<Person> personList = myPersonRepository.findAll();
        /**
         * 新增
         */
/*        List<Person> insertPersonList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                insertPersonList.add(new Person(("yangqc_" + i), new Point(i, j)));
            }
        }
        myPersonRepository.insert(insertPersonList);*/
/**
 * 测试查询
 */
//        personList = myPersonRepository.findByThePersonName("yangqc");
//        personList = myPersonRepository.findByName("yangqc_1");
//        personList=myPersonRepository.findByNameAndAge("yangqc_1",1);
//        personList = myPersonRepository.findByNameOrNameOrName("yangqc_1", "yangqc_2","yangqc_8");
//        personList = myPersonRepository.findByNameOrAge("yangqc_1", 9);
//        myPersonRepository.deleteByAgeBetween(0, 3);
//        myPersonRepository.findByNameLike("_");
        personList = myPersonRepository.findByThePersonName("yangqc_1");
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        MyPersonRepositoryTest myPersonRepositoryTest = annotationContext.getBean("myPersonRepositoryTest", MyPersonRepositoryTest.class);
        myPersonRepositoryTest.test();
    }
}
