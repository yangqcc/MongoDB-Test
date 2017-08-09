package com.yqc.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqc on 2017/3/15.
 */
@Component
public class SaveTest {

    @Autowired
    MongoOperations mongoOperations;

    public void saveEntity() {
        List<ResourceCategory> list = new ArrayList();
        ResourceCategory resourceCategory;
        for (int i = 10; i < 20; i++) {
            resourceCategory = new ResourceCategory();
            resourceCategory.setCategoryName("分类" + i);
            resourceCategory.setRelationTags(new String[]{"标签" + i, "模拟标签" + i, "测试标签" + i});
            list.add(resourceCategory);
        }
        mongoOperations.insert(list, ResourceCategory.class);
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.save");
        SaveTest saveTest = annotationContext.getBean("saveTest", SaveTest.class);
        saveTest.saveEntity();
    }
}
