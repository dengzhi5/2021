package com.dz.myteststarterspringbootstarter;

import com.dz.myteststarterspringbootstarter.service.Demo1StarterService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyTestStarterSpringBootStarterApplicationTests {
    @Resource
    Demo1StarterService demo1StarterService;

    @Test
    void contextLoads() {
    }
    @Test
    void aaa(){
        demo1StarterService.a();
    }

}
