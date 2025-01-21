package TriePractice;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        children = new HashMap<>();
        count = 0;
    }
}