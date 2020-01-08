package ru.job4j.LearnList;

public class SimpleQueu<T>  {
   private SimpleStack<T> stack1=new SimpleStack<>();
   private SimpleStack<T> stack2=new SimpleStack<>();
   private int i=0;

    public void push(T value) {
        stack1.push(value);
        i++;
    }
    public T poll() {
        for (int n=0;n<i;n++) {
            stack2.push(stack1.poll());
        }
        return stack2.poll();
    }

}
