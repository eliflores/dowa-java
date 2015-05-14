package com.dowa.web.service;

import java.util.Arrays;
import java.util.List;

public class FakeService {

    private static FakeService instance = null;
    private FakeService() {
    }

    public static FakeService getInstance() {
        synchronized (FakeService.class) {
            if (instance == null) {
                instance = new FakeService();
            }
        }
        return instance;
    }

    public List<String> getNames() {
        return Arrays.asList("name1", "name2", "name3");
    }
}
