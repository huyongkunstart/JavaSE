package com.TeamSchedule.java2;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解
 * @author hu
 * @create 2021-12-06 22:38
 */
@Repeatable(MyAnnotations.class) //可重复使用注解
@Inherited //继承
@Documented //Documented javadoc工具生成类的API文档时注解被保留下来，默认不保留
@Retention(RetentionPolicy.RUNTIME) //Retention：注解的声明周期    元注解：修饰注解的注解
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE}) //Target：注解能修饰哪些结构
public @interface MyAnnotation {
    String value() default "aaa";
}
