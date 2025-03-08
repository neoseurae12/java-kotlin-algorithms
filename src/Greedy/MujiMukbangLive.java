package Greedy;

public class MujiMukbangLive {
    public static int solution(int[] food_times, long k) {
        int currentK = 0;
        int currentFood = 0;
        int foodLeft = 0;
        int foodLen = food_times.length;

        while (currentK < k) {
            // 현재 음식에 남은 게 없다면 => '다음 음식'을 찾아 이동
            if (food_times[currentFood] == 0) {
                currentFood = (currentFood + 1) % foodLen;
                continue;
            }

            // 섭취 => 음식 양 1 감소 & 초 1 증가
            food_times[currentFood]--;
            foodLeft += food_times[currentFood];
            currentK++;

            // 모든 접시에 더 섭취해야 할 음식이 없다면 => -1 반환
            if (currentFood == foodLen - 1) {
                if (foodLeft == 0) {
                    return -1;
                }
                foodLeft = 0;
            }

            // 다음 음식으로 이동
            // 마지막 번호의 음식이었다면 => 다시 1번 음식으로 이동
            currentFood = (currentFood + 1) % foodLen;
        }

        // 결과 보정: 0번 -> 1번
        return currentFood + 1;
    }
}
