package com.hu.java2;

/**
 * 自定义注解
 * @author hu
 * @create 2021-12-06 22:38
 */ 
public @interface MyAnnotation {
    String value() default "hello";
}
