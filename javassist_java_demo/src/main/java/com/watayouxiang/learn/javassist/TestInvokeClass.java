package com.watayouxiang.learn.javassist;

import javassist.ClassPool;
import javassist.CtClass;

import java.lang.reflect.Method;

/**
 * 调用 .class 文件
 */
public class TestInvokeClass {
    /**
     * 通过放射方式调用
     */
    private static void call4reflect(CtClass cc) throws Exception {
        // 这里不写入文件，直接实例化
        Object person = cc.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "watayouxiang");
        // 输出值
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);
    }

    /**
     * 通过读取 .class 文件的方式调用
     */
    private static void call4classFile() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        // 设置类路径
        pool.appendClassPath("/Users/TaoWang/Desktop/javassist_demo/javassist_java_demo/src/main/java/");
        CtClass ctClass = pool.get("com.watayouxiang.learn.javassist.Person");
        Object person = ctClass.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "watayouxiang1");
        // 输出值
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);
    }

    /**
     * 通过接口的方式调用
     */
    private static void call4classInterface() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        pool.appendClassPath("/Users/TaoWang/Desktop/javassist_demo/javassist_java_demo/src/main/java/");

        // 获取接口
        CtClass codeClassI = pool.get("com.watayouxiang.learn.javassist.PersonI");
        // 获取上面生成的类
        CtClass ctClass = pool.get("com.watayouxiang.learn.javassist.Person");
        // 使代码生成的类，实现 PersonI 接口
        ctClass.setInterfaces(new CtClass[]{codeClassI});

        // 以下通过接口直接调用 强转
        PersonI person = (PersonI) ctClass.toClass().newInstance();
        person.setName("watayouxiang2");
        person.printName();
    }

    public static void main(String[] args) {
        try {
            call4reflect(TestCreateClass.createPersonClass());
//            call4classFile();
//            call4classInterface();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
