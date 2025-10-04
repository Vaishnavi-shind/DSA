import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    //DSA
    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // 1. Add the new element to the back of the queue
        q.offer(x);
        
        // 2. Rotate the queue elements: move all elements 
        //    before the new element to the back.
        //    We do this for size - 1 times.
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // The top element (most recent) is at the front
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        // The top element (most recent) is at the front
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */