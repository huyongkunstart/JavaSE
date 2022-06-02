package com.TeamSchedule.java2;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author huyongkun
 * @ClassName MyAnnotations
 * @create 2022-05-14 13:24
 * @Version 1.0
 * @description: TODO
 */
@Documented
@Inherited
//这两个注解是因为MyAnnotation中使用了@Repeatable(MyAnnotations.class) 可重复使用注解
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})

public @interface MyAnnotations {
    MyAnnotation[] value();
}
