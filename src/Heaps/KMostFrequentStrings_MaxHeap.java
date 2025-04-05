package Heaps;

/*
- Heaps > Finding Values in Sorted Order > Max Heap
    - 본 문제의 주요 도전과제
        - 1. 가장 빈번한 문자열 k개를 식별하기
        - 2. 문자열들 정렬하기 (우선순위: 1. frequency, 2. lexicographical)
    - 1. 가장 빈번한 문자열 k개를 식별하기
        - Hash Map 사용
        - 방법 (2가지)
            - 1. Hash Map -> Array -> Array 전체에 대해 내림차순 정렬
                - 비효율적인 방법
                - 본 문제에서는 '모든' element들이 정렬될 필요 없이, 'Top K개'의 element들에 한해서 정렬되면 된다!
            - 2. Max Heap
                - 언제든지 가장 빈번한 문자열에 효율적으로 액세스할 수 있는 데이터 구조
            - cf. Array Sort vs. Max Heap
                - Array Sort
                    - '전체' 정렬
                    - 시간복잡도: O(N log N)
                - Max Heap
                    - '부분' 정렬
                        - `부모 ≥ 자식`라는 규칙에 따라 항상 루트 노드가 최댓값이 되는 Heap 구조만 보장할 뿐
                            - 가장 큰 값만 빠르게 꺼내기에는 최적의 자료구조
                        - 형제 노드들끼리의 순서는 보장하지 않는다.
                    - 시간복잡도: O(N)
                        - sift-down 방식
        - Max Heap
            - 1. Max Heap 생성
                - (문자열, frequency) 저장
                    - Pair 클래스의 도입
                - 생성 방법 (2가지)
                    - 1. 모든 문자열들에 대해 push하기
                        - 비효율적인 방법
                        - 시간복잡도: O(N * log N)
                    - 2. heapify 연산 사용하기
                        - 효율적인 방법
                        - 시간복잡도: O(N)
            - 2. Max Heap에서 Top element를 k번 pop off하기
    - 2. 문자열들 정렬하기 (우선순위: 1. frequency, 2. lexicographical)
        - lexicographical하게 정렬 시 => custom comparator 사용
- 시간복잡도: O(N + K log N)
    - O(N) => Hash Map / Max Heap
    - O(K log N) => pop 연산(O(log N)) * k번
- 공간복잡도: O(N)
    - Hash Map / Max Heap
 */


import java.util.*;

public class KMostFrequentStrings_MaxHeap {
    public static class Pair implements Comparable<Pair> {
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

    public static List<String> kMostFrequentStringsMaxHeap(String[] strs, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> freqs = new HashMap<>();
        for (String str : strs)
            freqs.put(str, freqs.getOrDefault(str, 0) + 1);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().str);
        }

        return result;
    }
}
