package com.yqc.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yangqc on 2017/4/3.
 * lambda方法引用:
 * <p>
 * 方法引用有很多种，它们的语法如下：
 * <p>
 * 静态方法引用：ClassName::methodName
 * 实例上的实例方法引用：instanceReference::methodName
 * 超类上的实例方法引用：super::methodName
 * 类型上的实例方法引用：ClassName::methodName
 * 构造方法引用：Class::new
 * 数组构造方法引用：TypeName[]::new
 * <p>
 * 如果类型的实例方法是泛型的，那么我们就需要在::分隔符前提供类型参数，或者（多数情况下）利用目标类型推导出其类型。
 * 需要注意的是，静态方法引用和类型上的实例方法引用拥有一样的语法。编译器会根据实际情况做出决定。
 * 一般我们不需要指定方法引用中的参数类型，因为编译器往往可以推导出结果，但如果需要我们也可以显式在::分隔符之前提供参数类型信息。
 */
public class LambdaTest5 {

    public static void main(String[] args) {
        Person[] person = new Person[]{new Person("qicheng", 21), new Person("shijia", 21)};
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Arrays.sort(person, byName);
    }
}

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
