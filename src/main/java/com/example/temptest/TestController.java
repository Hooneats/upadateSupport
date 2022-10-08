package com.example.temptest;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestController {

    private final TestCommit testCommit;

    @PostConstruct
    public void test() {
        testCommit.update();
    }
}
