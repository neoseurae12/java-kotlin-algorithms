# Intervals

## Interval의 구성
- start point
- end point

## Interval의 표현

Interval => start point와 end point 사이의 모든 값을 포함하는 숫자 선의 연속적인 세그먼트

- 선
- 기간
- 연속적인 값의 범위

## Interval의 종류

1. Closed intervals
   - start <= x <= end
2. Open intervals
   - start < x < end
3. Half-open intervals
    - start <= x < end
    - start < x <= end

- 중요: interval의 open/close 여부를 꼭 명확히 해야 한다!
  - interval의 open/close 여부에 따라 overlap의 판단이 달라지기 때문이다.

## Intervals의 '겹침' (Overlapping)

- '겹침' (Overlapping) 이란
  - 2개 이상의 intervals가 적어도 하나의 공통 값을 서로 공유하는 경우
- Intervals 문제의 핵심
  - "겹치는가?"를 잘 보는 것도 중요하지만, "겹친다면 그걸 어떻게 처리해야 정답을 도출할 수 있는가"를 잘 파악하는 것

## Intervals의 '정렬' (Sorting)

- 문제를 풀기 전에 일단 interval들을 '정렬'해두는 것
  - 일정 순서에 따라 interval들을 처리할 수 있어서 꽤 도움됨
- 일반적인 정렬 기준 => chronological order
    - 1) start point
    - 2) (만약 start point가 서로 동일할 경우) end point까지 함께 고려

## start point & end point의 분리

- 어떤 경우에는 interval들의 start point & end point들을 각각 처리하는 것이 더 유리할 수 있다.
- 2개의 sorted array
  - 1) start point들을 모아둔 sorted array
  - 2) end point들을 모아둔 sorted array

## Interval 클래스의 정의

```java
public class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
```

## 실세계 예제
- `스케줄링 시스템`
  - e.g. 회의실 예약 시스템
    - 겹치는 예약의 최대 수
    - 충분한 회의실 가용성 보장
    - 이중 예약 방지

## 문제풀이 유형

- Managing Overlaps
- Finding Values in Sorted Order

### Managing Overlaps

### Fingind Values in Sorted Order
