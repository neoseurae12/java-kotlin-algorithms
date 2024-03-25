package Programmers;

import java.util.HashMap;

public class P12922_WatermelonJ {
    public String solution(int n) {
        String complete = "수박";
        String half = "수";
        if (n % 2 == 0) {   // 짝수
            return complete.repeat(n / 2);
        } else {    // 홀수
            return complete.repeat(n / 2) + half;
        }
    }
}
