import java.util.*;

class Stack{
    ArrayList<Integer> items;

    Stack(){
        items = new ArrayList<>();
    }

    public void push(int item){
        items.add(item);
    }

    public Integer pop(){
        if(!items.isEmpty()){
            return items.remove(items.size()-1);
        }
        return null;
    }

    public Integer peek(){
        if(!items.isEmpty()){
            return items.get(items.size()-1);
        }
        return null;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
    public static void main(String[] args){  
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); //3
        System.out.println(stack.peek()); //2
        System.out.println(stack.isEmpty()); //false
    }
}
