package com.example.pesto.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AmplitudeUtils implements AnalyticsEventDispatcherInterface {
    @Override
    public void send(String jsonString) {
        log.info("Event sent to amplitude : {}", jsonString);
    }
}
