# Heaps

## 주요 타입 (2가지)
- Min-heap
- Max-heap

## Heap의 구조
`Binary Tree` => 효율적인 prioritization

## Heap의 주요 연산별 시간복잡도
- Insert => O(log N)
- Delete => O(log N)
- Peek => O(1)
- Heapify => O(N)
    - 파이썬 한정의 연산 함수
    - unsorted list -> heap 으로 전환하는 함수

cf) [Heap의 내부 구현 / 다양한 연산 중에도 binary tree 구조가 유지되는 원리](https://en.wikipedia.org/wiki/Binary_heap)

## Priority Queue
- Heap의 특별한 유형
- prioritization의 기준의 customization 가능

## 실세계 예제

- `OS의 task 관리`
  - Priority Queue 사용
  - 다수의 프로세스들에 우선순위를 부여하여 스케줄링함
  - 시스템이 가장 높은 우선순위의 task에 빠르게 접근할 수 있도록 하고, 새로운 task들이 추가되거나 기존 task들이 완료될 때마다 우선순위를 효율적으로 재조정할 수 있도록 함

## 문제풀이 유형
- Sorting
- Finding Values in Sorted Order

### Sorting

### Finding Values in Sorted Order
