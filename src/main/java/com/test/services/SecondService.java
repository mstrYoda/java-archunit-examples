package com.test.services;

public class SecondService {
    private FirstService firstService;

    public SecondService() {
        this.firstService = new FirstService();
    }
}
