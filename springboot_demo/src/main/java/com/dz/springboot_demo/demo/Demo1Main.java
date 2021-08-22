package com.dz.springboot_demo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableDzImport
public class Demo1Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo1Main.class);
        System.out.println(context.getBean(Demo2Service.class));
    }
}
