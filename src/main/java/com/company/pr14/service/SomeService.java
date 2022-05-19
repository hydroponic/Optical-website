package com.company.pr14.service;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    @LogExecutionTime
    public void someMethod() {
        System.out.println("some method of service");
    }
}
