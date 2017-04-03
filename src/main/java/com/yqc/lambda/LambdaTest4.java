package com.yqc.lambda;

import java.util.concurrent.Callable;

/**
 * Created by yangqc on 2017/4/3.
 * 测试Lambda方式引用方法
 * <p>
 * lambda表达式对目标类型也是有要求的。编译器会检查lambda表达式的类型和目标类型的方法签名（method signature）是否一致。
 * 当且仅当下面所有条件均满足时，lambda表达式才可以被赋给目标类型T：
 * <p>
 * T是一个函数式接口
 * lambda表达式的参数和T的方法参数在数量和类型上一一对应
 * lambda表达式的返回值和T的方法返回值相兼容（Compatible）
 * lambda表达式内所抛出的异常和T的方法throws类型相兼容
 * <p>
 * <p>
 * lambda表达式不会从超类中继承任何变量名，也不会引入一个新的作用域
 * 相对于内部类，lambda表达式的语义就十分简单：它不会从超类（supertype）中继承任何变量名，也不会引入一个新的作用域。
 * lambda表达式基于词法作用域，也就是说lambda表达式函数体里面的变量和它外部环境的变量具有相同的语义（也包括lambda表达式的形式参数）。
 * 此外，'this'关键字及其引用在lambda表达式内部和外部也拥有相同的语义。
 */
public class LambdaTest4 {

    Runnable r1 = () -> {
        System.out.println(this);
    };

    Runnable r2 = () -> {
        System.out.println(toString());
    };

    Runnable r3 = new Runnable() {
        //this指向当前内部类对象
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    Runnable r4 = new Runnable() {
        //调用了超类的方法
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    public String toString() {
        return "Hello,World!";
    }

    public void getMethod(boolean flag) {
        Callable<Integer> c = flag ? (() -> 23) : (() -> 42);
    }

    public void showThis() {

    }

    /**
     * 基于词法作用域的理念，lambda表达式不可以掩盖任何其所在上下文中的局部变量，
     * 它的行为和那些拥有参数的控制流结构（例如for循环和catch从句）一致。
     *
     * @param args
     */

    public static void main(String[] args) {
        //可以转型
        Object o = (Runnable) () -> {
            System.out.println("");
        };

        new LambdaTest4().r1.run();
        new LambdaTest4().r2.run();
        new LambdaTest4().r3.run();
        new LambdaTest4().r4.run();
    }
}
