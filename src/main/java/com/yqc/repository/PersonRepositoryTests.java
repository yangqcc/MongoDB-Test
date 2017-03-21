package com.yqc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/12.
 */
@Component
public class PersonRepositoryTests {

    @Autowired
    PersonRepository personRepository;

/*    public void readsFirstPageCorrectly() {
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
    }*/

    public void testMyRepository(){
        personRepository.sayHello("yangqc1");
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.repository");
        // 创建bean的引用对象
        PersonRepositoryTests personRepositoryTests = annotationContext.getBean("personRepositoryTests", PersonRepositoryTests.class);
//        personRepositoryTests.readsFirstPageCorrectly();
        personRepositoryTests.testMyRepository();
    }
}
