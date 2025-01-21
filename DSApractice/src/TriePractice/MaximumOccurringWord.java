package TriePractice;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccurringWord {
    TrieNode root;
    String maxWord;
    int maxCount;

    public MaximumOccurringWord() {
        root = new TrieNode();
        maxWord = "";
        maxCount = 0;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.count++;
        if (node.count > maxCount) {
            maxCount = node.count;
            maxWord = word;
        }
    }

    public String findMaxOccurringWord(String[] words) {
        MaximumOccurringWord trie = new MaximumOccurringWord();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.maxWord;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "banana"};
        MaximumOccurringWord maxWordFinder = new MaximumOccurringWord();
        String maxWord = maxWordFinder.findMaxOccurringWord(words);
        System.out.println("Maximum occurring word: " + maxWord);
    }
}