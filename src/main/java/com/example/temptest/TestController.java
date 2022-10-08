package com.example.temptest;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostConstruct
    public void test() {
        testService.update();
    }
}
