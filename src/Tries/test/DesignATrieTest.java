package Tries.test;

import Tries.DesignATrie_Array;
import Tries.DesignATrie_HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignATrieTest {

    @Nested
    class ArrayTests {
        DesignATrie_Array trie;

        @BeforeEach
        void setUp() {
            trie = new DesignATrie_Array();
        }

        @Test
        void testBasicCase() {
            trie.insert("top");
            trie.insert("bye");

            assertTrue(trie.hasPrefix("to"));
            assertFalse(trie.search("to"));

            trie.insert("to");
            assertTrue(trie.search("to"));
        }

        @Test
        void testInsertAndSearchBasicWord() {
            trie.insert("apple");
            assertTrue(trie.search("apple"));
            assertFalse(trie.search("app"));
        }

        @Test
        void testInsertAndSearchWithCommonPrefix() {
            trie.insert("app");
            trie.insert("apple");
            assertTrue(trie.search("app"));
            assertTrue(trie.search("apple"));
            assertFalse(trie.search("appl"));
        }

        @Test
        void testHasPrefix() {
            trie.insert("banana");
            assertTrue(trie.hasPrefix("ban"));
            assertTrue(trie.hasPrefix("bana"));
            assertTrue(trie.hasPrefix("banana"));
            assertFalse(trie.hasPrefix("band"));
            assertFalse(trie.hasPrefix("bann"));
        }

        @Test
        void testSearchAndPrefixOnEmptyTrie() {
            assertFalse(trie.search("anything"));
            assertFalse(trie.hasPrefix("any"));
        }

        @Test
        void testMultipleInsertions() {
            String[] words = {"cat", "cap", "car", "dog", "dove"};
            for (String word : words) {
                trie.insert(word);
            }

            for (String word : words) {
                assertTrue(trie.search(word), "Should find: " + word);
            }

            assertFalse(trie.search("ca"));
            assertTrue(trie.hasPrefix("ca"));
            assertTrue(trie.hasPrefix("do"));
            assertFalse(trie.hasPrefix("z"));
        }

        @Test
        void testInsertDuplicateWord() {
            trie.insert("same");
            trie.insert("same");
            assertTrue(trie.search("same"));
        }
    }

    @Nested
    class HashMapTests {
        DesignATrie_HashMap trie;

        @BeforeEach
        void setUp() {
            trie = new DesignATrie_HashMap();
        }

        @Test
        void testBasicCase() {
            trie.insert("top");
            trie.insert("bye");

            assertTrue(trie.hasPrefix("to"));
            assertFalse(trie.search("to"));

            trie.insert("to");
            assertTrue(trie.search("to"));
        }

        @Test
        void testInsertAndSearchBasicWord() {
            trie.insert("apple");
            assertTrue(trie.search("apple"));
            assertFalse(trie.search("app"));
        }

        @Test
        void testInsertAndSearchWithCommonPrefix() {
            trie.insert("app");
            trie.insert("apple");
            assertTrue(trie.search("app"));
            assertTrue(trie.search("apple"));
            assertFalse(trie.search("appl"));
        }

        @Test
        void testHasPrefix() {
            trie.insert("banana");
            assertTrue(trie.hasPrefix("ban"));
            assertTrue(trie.hasPrefix("bana"));
            assertTrue(trie.hasPrefix("banana"));
            assertFalse(trie.hasPrefix("band"));
            assertFalse(trie.hasPrefix("bann"));
        }

        @Test
        void testSearchAndPrefixOnEmptyTrie() {
            assertFalse(trie.search("anything"));
            assertFalse(trie.hasPrefix("any"));
        }

        @Test
        void testMultipleInsertions() {
            String[] words = {"cat", "cap", "car", "dog", "dove"};
            for (String word : words) {
                trie.insert(word);
            }

            for (String word : words) {
                assertTrue(trie.search(word), "Should find: " + word);
            }

            assertFalse(trie.search("ca"));
            assertTrue(trie.hasPrefix("ca"));
            assertTrue(trie.hasPrefix("do"));
            assertFalse(trie.hasPrefix("z"));
        }

        @Test
        void testInsertDuplicateWord() {
            trie.insert("same");
            trie.insert("same");
            assertTrue(trie.search("same"));
        }
    }
}