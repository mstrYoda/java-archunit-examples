package com.test.services;

public class FirstService {
    private SecondService secondService;

    public FirstService() {
        this.secondService = new SecondService();
    }
}
