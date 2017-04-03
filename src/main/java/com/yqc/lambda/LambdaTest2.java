package com.yqc.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yangqc on 2017/4/3.
 */
public class LambdaTest2 {

    public static void testSearch() {
        List<Dog> dogList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogList.add(new Dog("yangqc" + i));
        }

        List<Cat> catList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            catList.add(new Cat("yangqc" + i, i));
        }

        /**
         * 设置值
         */
        List<Dog> finalDogList = dogList.stream().map(people -> {
            Cat cat1 = null;
            if ((cat1 = catList.stream().distinct().filter(cat -> people.getName().equals(cat.getName())).findFirst().orElse(null)) != null) {
                people.setAge(cat1.getAge());
            }
            return people;
        }).collect(Collectors.toList());

        /**
         * 测试anyMatch
         */
        System.out.println(dogList.stream().anyMatch(dog -> dog.getName().equals("yangqc2")));

        /**
         * 测试allMatch
         */
        System.out.println(dogList.stream().allMatch(dog -> dog.getName().equals("yangqc2")));

        for (Dog dog : finalDogList) {
            System.out.println(dog);
        }
    }

    /**
     * map进行过滤
     */
    public static void testMap() {
        Map<String, Dog> map = new HashMap<>();
        List<Cat> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            map.put("yangqc" + i, new Dog("yangqc" + i));
            list.add(new Cat("yangqc" + i, i));
        }

        map.replaceAll((name, dog) -> {
            if (name.equals("yangqc1")) {
                dog.setAge(21);
            }
            return dog;
        });

        List<Cat> finalList = list.stream().map(cat -> {
            Dog dog = null;
            if ((dog = map.entrySet().stream().filter(entry -> cat.getName().equals(entry.getKey())).findFirst().orElse(null).getValue()) != null) {
                cat.setAge(dog.getAge());
            }
            return cat;
        }).collect(Collectors.toList());

//        for (Map.Entry<String, People> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " ** " + entry.getValue());
//        }
        for (Cat cat : finalList) {
            System.out.println(cat);
        }
    }

    public static void main(String[] args) {
//        testSearch();
        testMap();
    }
}
