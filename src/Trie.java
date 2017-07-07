/**
 * Created by xuan on 2017/7/5 0005.
 */
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        int len = word.length();
        if (len == 0) return;
        char c;
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            c = word.charAt(i);
            if (current.child[c-'a'] == null) current.child[c-'a'] = new TrieNode();
            current = current.child[c-'a'];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (root == null || word == null) return false;
        int len = word.length();
        if (len == 0) return false;
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (current.child == null || current.child[c-'a'] == null) return false;
            current = current.child[c-'a'];
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (root == null || prefix == null) return false;
        int len = prefix.length();
        if (len == 0) return false;
        TrieNode current = root;
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (current.child == null || current.child[c-'a'] == null) return false;
            current = current.child[c-'a'];
        }
        return true;
    }
}

class TrieNode {
    public boolean isWord;
    TrieNode[] child;

    public TrieNode() {
        isWord = false;
        child = new TrieNode[26];
    }
}
