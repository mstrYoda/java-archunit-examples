package com.test.infrastructure;

import com.test.Repository;
import com.test.services.slice2.SecondService;

@Repository
public class FirstRepository {
    SecondService secondService;

    public FirstRepository(SecondService secondService) {
        this.secondService = secondService;
    }
}
