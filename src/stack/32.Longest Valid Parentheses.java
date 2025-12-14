//32. Longest Valid Parentheses - https://leetcode.com/problems/longest-valid-parentheses/
//Time Complexity: O(n) and Space Complexity: O(n)
import java.util.Stack;

class solution{
    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxValid = 0;

        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxValid = Math.max(maxValid, i-stack.peek());
                }
            }
        }
        return maxValid;
    }
}