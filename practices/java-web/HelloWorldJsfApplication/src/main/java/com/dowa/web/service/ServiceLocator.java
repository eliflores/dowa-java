package com.dowa.web.service;


public class ServiceLocator {
    private ServiceLocator() {
    }

    public static FakeService getFakeService() {
        return FakeService.getInstance();
    }
}
