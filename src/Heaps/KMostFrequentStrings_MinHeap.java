package Heaps;

/*
- Heaps > Finding Values in Sorted Order > Min Heap
    - Max Heap ver.에서 더 나아가, Heap의 공간복잡도를 더 줄일 수 있는 방법!
        - Heap의 공간복잡도: O(N) -> O(K)
    - Heap의 크기를 k 이하로 유지시키자!
        - 사실상 상위 k개를 제외하고는, 그 이하 순위들은 절대 답이 될리가 없다.
        - Heap의 크기가 k를 넘어설 때마다 아랫 순위들은 버리자.
    - Min Heap
        - '버릴 아랫 순위'를 식별 가능
    - 최종 답(`result`) => min heap의 역순서
- 시간복잡도: O(N log K)
    - Map 생성 => O(N)
    - Min Heap 생성 (push & pop) => O(N log K)
    - Min Heap -> result 옮겨 담기 => O(K log K)
    - result 역순서 => O(K)
    - O(N) + O(N log K) + O(K log K) + O(K) = O(N log K)
- 공간복잡도: O(N)
    - Map => O(N)
    - Min Heap => O(K)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentStrings_MinHeap {
    static class Pair implements Comparable<Pair> {
        String str;
        int freq;

        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.freq == other.freq) {
                // reverse lexicographical order
                return other.str.compareTo(this.str);
            }

            // lower-frequency order
            return Integer.compare(this.freq, other.freq);
        }
    }

    public static List<String> kMostFrequentStringsMinHeap(String[] strs, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> freqs = new HashMap<>();
        for (String str : strs)
            freqs.put(str, freqs.getOrDefault(str, 0) + 1);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            minHeap.add(new Pair(entry.getKey(), entry.getValue()));

            if (minHeap.size() > k)
                minHeap.poll();
        }

        while (!minHeap.isEmpty())
            result.add(minHeap.poll().str);

        Collections.reverse(result);

        return result;
    }
}
