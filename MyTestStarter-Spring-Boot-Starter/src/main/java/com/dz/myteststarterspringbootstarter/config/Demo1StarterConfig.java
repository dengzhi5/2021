package com.dz.myteststarterspringbootstarter.config;

import com.dz.myteststarterspringbootstarter.service.Demo1StarterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo1StarterConfig {

    @Bean
    public Demo1StarterService demo1StarterService(){
        return new Demo1StarterService();
    }
}
