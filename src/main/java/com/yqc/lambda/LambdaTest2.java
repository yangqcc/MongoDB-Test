package com.yqc.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yangqc on 2017/4/3.
 */
public class LambdaTest2 {

    public static void testSearch() {
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            peopleList.add(new People("yangqc" + i));
        }

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person("yangqc" + i, i));
        }

        /**
         * 设置值
         */
        List<People> peopleList1 = peopleList.stream().map(people -> {
            Person person1 = null;
            if ((person1 = personList.stream().distinct().filter(person -> people.getName().equals(person.getName())).findFirst().orElse(null)) != null) {
                people.setAge(person1.getAge());
            }
            return people;
        }).collect(Collectors.toList());

        /**
         * 测试anyMatch
         */
        System.out.println(peopleList1.stream().anyMatch(people -> people.getName().equals("yangqc2")));

        /**
         * 测试allMatch
         */
        System.out.println(peopleList1.stream().allMatch(people -> people.getName().equals("yangqc2")));

        for (People people : peopleList1) {
            System.out.println(people);
        }
    }

    /**
     * map进行过滤
     */
    public static void testMap() {
        Map<String, People> map = new HashMap<>();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            map.put("yangqc" + i, new People("yangqc" + i));
            list.add(new Person("yangqc" + i, i));
        }

        map.replaceAll((name, people) -> {
            if (name.equals("yangqc1")) {
                people.setAge(21);
            }
            return people;
        });

        List<Person> finalList = list.stream().map(person -> {
            People people = null;
            if ((people = map.entrySet().stream().filter(entry -> person.getName().equals(entry.getKey())).findFirst().orElse(null).getValue()) != null) {
                person.setAge(people.getAge());
            }
            return person;
        }).collect(Collectors.toList());

//        for (Map.Entry<String, People> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " ** " + entry.getValue());
//        }
        for (Person person : finalList) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
//        testSearch();
        testMap();
    }
}
