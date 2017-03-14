package com.yqc.repository;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
@Component
public class PersonRepositoryTests {

    @Autowired
    PersonRepository personRepository;

    public void readsFirstPageCorrectly() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person("yangqc", i,"orange"));
        }
        personRepository.save(personList);
        List<Person> persons = personRepository.findByName("yangqc", new PageRequest(0, 20));
        persons = personRepository.findByAgeAfter(8);
        persons = personRepository.findByAgeGreaterThanEqual(8);
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.repository");
        // 创建bean的引用对象
        PersonRepositoryTests personRepositoryTests = annotationContext.getBean("personRepositoryTests", PersonRepositoryTests.class);
        personRepositoryTests.readsFirstPageCorrectly();
    }
}
