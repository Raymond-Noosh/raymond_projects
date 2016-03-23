package com.raymond;

import com.raymond.beans.Person;
import com.raymond.config.AppConfig;
import com.raymond.examples.Singleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = ctx.getBean(Person.class);
        person.setEmail("raym123@hotmail.com");
        person.setName("Raymond");


        Singleton.getInstance();
    }
}
