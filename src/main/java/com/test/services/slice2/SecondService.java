package com.test.services.slice2;

import com.test.services.slice1.FirstService;

public class SecondService {
    private FirstService firstService;

    public SecondService() {
        this.firstService = new FirstService();
    }
}
