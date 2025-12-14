//716. Max Stack - https://leetcode.com/problems/max-stack/
//Time Complexity: O(1) (worst case O(n) for popMax) for all operations and Space Complexity: O(n)
import java.util.Stack;

class MaxStack{
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    MaxStack(){
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int num){
        int max = maxStack.isEmpty() ? num : Math.max(num, maxStack.peek());
        stack.push(num);
        maxStack.push(max);
    }

    public Integer pop(){
        maxStack.pop();
        return stack.pop();
    }

    public Integer peek(){
        return stack.peek();
    }

    public Integer top(){
        return stack.peek();
    }

    public Integer peekMax(){
        return maxStack.peek();
    }

    public Integer popMax(){
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(top() != max){
            buffer.push(pop());
        }
        pop();
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return max;
    }

}
