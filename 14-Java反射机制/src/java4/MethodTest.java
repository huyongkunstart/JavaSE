package java4;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author hu
 * @create 2022-01-29 15:51
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        //getMethods（）:获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }

        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包括父类中声明的方法）
        System.out.println("******************************");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }


    /*
    *  注解
    * 权限修饰符  返回值类型   方法名
    * */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            //1.获取方法的注解
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations){
                System.out.print(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表

            Class [] parameterTypes = m.getParameterTypes();
            for(int i =0 ; i< parameterTypes.length ; i++){

                if(i == parameterTypes.length - 1){
                    System.out.print(parameterTypes[i].getName() + " args_" + i);
                    break;
                }

                System.out.print(parameterTypes[i].getName() + " args_" + i+",");
            }
            System.out.print(") ");
            //6.抛出异常
            Class [] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print(" throws ");
                for(int i =0;i<exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+ ",");
                }
            }
            System.out.println();
        }




    }



}
