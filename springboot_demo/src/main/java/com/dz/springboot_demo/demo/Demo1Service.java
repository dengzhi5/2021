package com.dz.springboot_demo.demo;

import com.dz.myteststarterspringbootstarter.service.Demo1StarterService;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Demo1Service {
    @Resource
    private Demo1StarterService demo1StarterService;

    public void b(){
        demo1StarterService.a();
    }
}
