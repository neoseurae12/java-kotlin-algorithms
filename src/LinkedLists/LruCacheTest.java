package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {
    private LruCache lruCache;

    @BeforeEach
    void setUp() {
        lruCache = new LruCache(3);
    }

    @Test
    void testPutAndGet() {
        lruCache.put(1, 100);
        lruCache.put(2, 250);
        assertEquals(250, lruCache.get(2));
        assertEquals(100, lruCache.get(1));
    }

    @Test
    void testCacheEviction() {
        lruCache.put(1, 100);
        lruCache.put(2, 250);
        lruCache.put(4, 300);
        lruCache.put(3, 200);   // 가장 오래된 (1, 100)을 evict 해야 함

        assertEquals(-1, lruCache.get(1)); // -1 반환
        assertEquals(250, lruCache.get(2));
        assertEquals(200, lruCache.get(3));
    }

    @Test
    void testUpdateValue() {
        lruCache.put(1, 10);
        lruCache.put(1, 100); // 기존 키(1)의 값 업데이트
        assertEquals(100, lruCache.get(1)); // 100
    }

    @Test
    void testLRUOrdering() {
        lruCache.put(1, 100);
        lruCache.put(2, 250);
        lruCache.put(4, 300);
        lruCache.get(1);    // 1번 => 최신 상태
        lruCache.put(3, 200);   // 캐시 크기 초과 => 제거 대상: 2

        assertEquals(100, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
        assertEquals(200, lruCache.get(3));
    }
}