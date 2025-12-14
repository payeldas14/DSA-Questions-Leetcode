//622. Design Circular Queue - https://leetcode.com/problems/design-circular-queue/
//Time Complexity: O(1) for all operations and Space Complexity: O(n)
import java.util.*;

class MyCircularQueue{
    int[] queue;
    int cap;
    int head;
    int size;

    MyCircularQueue(int k){
        queue = new int[k];
        cap = k;
        head = 0;
        size = 0;
    }

    public boolean enqueue(int value){
        if(isFull()) return false;
        int tail = (head + size) % cap;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean dequeue(){
        if(isEmpty()) return false;
        head = (head + 1) % cap;
        size--;
        return true;
    }

    public int front(){
        if(isEmpty()) return -1;
        int tail = (head + size - 1) % cap;
        return queue[tail];
    }

    public int rear(){
        if(isEmpty()) return -1;
        return queue[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == cap;
    }
}
