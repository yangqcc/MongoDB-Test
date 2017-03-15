package com.yqc.query;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqc on 2017/3/15.
 * 测试save和insert的区别，如果记录之前不存在，那么save和insert效果一样
 * 如果存在，save会更新记录，而insert会报错
 * <p>
 * {@link insert} inserts an object. If there is an existing document with the same id then an error is
 * generated.
 * {@link insertAll} takes a Collection of objects as the first parameter. This method inspects each object
 * and inserts it to the appropriate collection based on the rules specified above.
 * {@link save} saves the object overwriting any object that might exist with the same id.
 */
@Component
public class SaveAndInsert {

    @Autowired
    MongoOperations mongoOperations;

    public void saveAndInsert() {
        List<Fruit> fruitList = new ArrayList<Fruit>();
/*        for (int i = 0; i < 10; i++) {
            fruitList.add(new Fruit(new Integer(i).toString(), "orange" + i));
        }
        mongoOperations.insert(fruitList, Fruit.class);*/
        List multipleList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            multipleList.add(new Fruit("orange"));
        }
        for (int i = 0; i < 10; i++) {
            multipleList.add(new Person("person" + i, i));
        }
        /**
         * insertAll居然可以混合插入
         */
        mongoOperations.insertAll(multipleList);
        /*List<Fruit> fruitList1 = mongoOperations.findAll(Fruit.class);
        fruitList1.get(0).setName("Apple");
        mongoOperations.save(new Fruit("xxx"));
        mongoOperations.insert(new Fruit("2", "Orange"));*/
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        SaveAndInsert saveAndInsert = annotationContext.getBean("saveAndInsert", SaveAndInsert.class);
        saveAndInsert.saveAndInsert();
    }
}
