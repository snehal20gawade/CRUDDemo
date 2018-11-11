package com.postgres.cruddemo;

import com.postgres.cruddemo.configuration.HelloWorld;
import com.postgres.cruddemo.configuration.SpringConfiguration;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBean {
public static void main(String args[]){
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(SpringConfiguration.class);
 HelloWorld helloWorld  = applicationContext.getBean(HelloWorld.class);
 System.out.println(helloWorld.getMsg());

}
}
