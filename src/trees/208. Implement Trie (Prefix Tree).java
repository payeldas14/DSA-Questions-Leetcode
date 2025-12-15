//208. Implement Trie (Prefix Tree) - https://leetcode.com/problems/implement-trie-prefix-tree/
//Time Complexity: O(L) where L is the length of the word, Space Complexity: O(n) where n is the number of nodes in the trie
package trees;

class Trie{

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    
}
