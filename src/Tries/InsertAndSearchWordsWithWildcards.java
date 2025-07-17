package Tries;

import datatype.TrieNode;

public class InsertAndSearchWordsWithWildcards {
    TrieNode root;

    public InsertAndSearchWordsWithWildcards() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(0, word, root);
    }

    private boolean searchHelper(int wordIndex, String word, TrieNode node) {
        for (int i = wordIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            // 와일드카드 문자 => 각 child node들로부터 단어의 나머지 문자들에 대해 recursive하게 검색하기
            if (c == '.') {
                for (TrieNode child : node.children.values()) {
                    // 일치하는 match 발견 => true 반환
                    if (searchHelper(i + 1, word, child)) {
                        return true;
                    }
                }
                return false;
            }
            else if (node.children.containsKey(c))
                node = node.children.get(c);
            else
                return false;
        }
        // 마지막 문자에 다다랐을 경우 => 단어의 끝이 맞는지 여부에 따라 true/false 반환
        return node.isWord;
    }
}
