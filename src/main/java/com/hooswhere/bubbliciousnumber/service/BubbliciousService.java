package com.hooswhere.bubbliciousnumber.service;

import com.hooswhere.bubbliciousnumber.util.BubbliciousUtil;
import org.springframework.stereotype.Service;

@Service
public class BubbliciousService {

    public int findBubbliciousNumbersUpTo(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (BubbliciousUtil.isPrime(i) && BubbliciousUtil.hexEndsInB(i)) {
                count++;
                String hex = Integer.toHexString(i);
                System.out.println(i + "; Hex value: " + hex);
            }
        }
        return count;
    }
}
