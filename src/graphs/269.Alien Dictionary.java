//269. Alien Dictionary - https://leetcode.com/problems/alien-dictionary/description/
//Time Complexity: O(C) - total number of characters in all words, to create unique character hashMap, add dependency and traverse over the hashMap
//Space Complexity: O(1), depends on the unique characters, 26 characters
import java.util.*;

class solution{
    HashMap<Character, List<Character>> reverseList = new HashMap<>();
    HashMap<Character, Boolean> seen = new HashMap<>();
    StringBuilder result = new StringBuilder();

    public String alienOrder(String[] words) {
        for(String word : words){
            for(char j : word.toCharArray()){
                reverseList.putIfAbsent(j, new ArrayList<>());
            }
        }

        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    reverseList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        for(char c : reverseList.keySet()){
            if(!dfs(c)) return "";
        }

        if(result.length() < reverseList.size()){
            return "";
        }
        return result.toString();
    }

    private boolean dfs(char c){
        if(seen.containsKey(c)){
            return seen.get(c);
        }

        seen.put(c, false);

        for(char ch : reverseList.get(c)){
            if(!dfs(ch)){
                return false;
            }
        }

        seen.put(c, true);
        result.append(c);
        return true;
    }
}