package com.yqc.lambda;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by yangqc on 2017/4/2.
 */
public class LambdaTest1 {

    public Method getMethod(Class<?> target, String methodName, Class<?>[] parameterTypes, Class<?> returnType) {
        for (Method method : target.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                Class<?>[] candidateParamClass = method.getParameterTypes();
                if (candidateParamClass.length == parameterTypes.length) {
                    boolean matches = true;
                    for (int i = 0; i < candidateParamClass.length; i += 1) {
                        if (!candidateParamClass[i].equals(parameterTypes[i])) {
                            matches = false;
                            break;
                        }
                    }
                    if (matches) {
                        if (method.getReturnType().equals(returnType)) {
                            return method;
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    /**
     * Lambda版本
     * @param target
     * @param methodName
     * @param parameterTypes
     * @param returnType
     * @return
     */
    public Method getMethodLambda(Class<?> target, String methodName, Class<?>[] parameterTypes, Class<?> returnType) {
        return Arrays.stream(target.getDeclaredMethods())
                .filter(m -> Objects.equals(m.getName(), methodName))
                .filter(m -> Arrays.equals(m.getParameterTypes(), parameterTypes))
                .filter(m -> Objects.equals(m.getReturnType(), returnType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());
    }

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("yangqc", 21), new Person("shijia", 13), new Person("chaochao", 21)};

        Comparator<Person> byName = Comparator.comparing(p -> p.getName());

        Arrays.sort(people, byName);

        Person person = new Person("yangqc", 21);
    }
}
