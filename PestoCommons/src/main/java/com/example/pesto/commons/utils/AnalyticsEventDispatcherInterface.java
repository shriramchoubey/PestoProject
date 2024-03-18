package com.example.pesto.commons.utils;

import org.springframework.stereotype.Service;

@Service
public interface AnalyticsEventDispatcherInterface {
    void send(String jsonString);
}
