package com.yqc.repository;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Administrator on 2017/3/12.
 */
public class PersonRepositoryTests {
    @Autowired
    PersonRepository personRepository;

    public void readsFirstPageCorrectly() {
        Page<Person> persons = personRepository.findAll(new PageRequest(0, 10));
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc");
        // 创建bean的引用对象
        MongoOperations mongoOperations = annotationContext.getBean("mongoTemplate", MongoTemplate.class);
        new PersonRepositoryTests().readsFirstPageCorrectly();
    }
}
