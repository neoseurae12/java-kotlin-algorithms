package Greedy;

import java.util.Scanner;

public class UntilItReaches1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cntUntil1 = 0;

        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();

        while (n != 1) {
            int untilMultiple = n % k;
            if (untilMultiple == 0) {
                n /= k;
                cntUntil1++;
            }
            else {
                cntUntil1 += untilMultiple;
                n -= untilMultiple;
            }
        }

        System.out.println(cntUntil1);
    }
}
