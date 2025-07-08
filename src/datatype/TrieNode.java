package datatype;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // HashMap으로 구현한 children
    public Map<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}
