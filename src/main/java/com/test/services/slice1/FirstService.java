package com.test.services.slice1;

import com.test.services.slice2.SecondService;

public class FirstService {
    private SecondService secondService;

    public FirstService() {
        this.secondService = new SecondService();
    }
}
