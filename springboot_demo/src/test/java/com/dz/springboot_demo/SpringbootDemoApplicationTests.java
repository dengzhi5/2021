package com.dz.springboot_demo;

import com.dz.springboot_demo.demo.Demo1Service;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Resource
    Demo1Service demo1Service;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        demo1Service.b();
    }
}
