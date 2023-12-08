package com.hooswhere.bubbliciousnumber.controller;

import com.hooswhere.bubbliciousnumber.service.BubbliciousService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BubbliciousController {
    private final BubbliciousService bubbliciousService;

    public BubbliciousController(BubbliciousService bubbliciousService) {
        this.bubbliciousService = bubbliciousService;
    }

    @GetMapping("/bubblicious")
    public int getBubblicious() {
        long start = System.currentTimeMillis();
        int count = bubbliciousService.findBubbliciousNumbersUpTo(100000);
        long end = System.currentTimeMillis();
        long durationSecs = (end - start) / 1000;
        System.out.println("Found " + count + " bubblicious numbers up to 100k in " + durationSecs + " seconds");
        return count;
    }
}
