package com.dz.springboot_demo.demo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DzImport.class)
public @interface EnableDzImport {
}
