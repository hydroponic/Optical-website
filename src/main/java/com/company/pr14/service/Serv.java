package com.company.pr14.service;

import org.springframework.stereotype.Component;

@Component
public class Serv {
    @LogExecutionTime
    public void test() {
        System.out.println("Some method of component");
    }
}
