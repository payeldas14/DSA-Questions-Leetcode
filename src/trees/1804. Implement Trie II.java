//1804. Implement Trie II - https://leetcode.com/problems/implement-trie-ii-data-structure-design/
//Time Complexity: O(L) where L is the length of the word, Space Complexity: O(n) where n is the number of nodes in the trie
package trees;

class Trie {

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int prefixCount = 0; // number of words passing through
        int wordCount = 0;   // number of words ending here
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
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    // Count exact word occurrences
    public int countWordsEqualTo(String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.wordCount;
    }

    // Count words starting with prefix
    public int countWordsStartingWith(String prefix){
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.prefixCount;
    }

    public void erase(String word){
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            TrieNode next = curr.children[index];

            next.prefixCount--;

            if(next.prefixCount == 0){
                curr.children[index] = null;
                return;
            }

            curr = next;
        }
        curr.wordCount--;
    }
    
}
