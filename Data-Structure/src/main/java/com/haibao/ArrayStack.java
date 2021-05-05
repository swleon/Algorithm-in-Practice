package com.haibao;

/**
 * 数组实现的栈
 *
 * @author ml.c
 * @date 4:34 PM 5/5/21
 **/
public class ArrayStack<T> implements Stack<T> {

    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<T>(capacity);
    }

    public ArrayStack() {
        array = new Array<T>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(T t) {
        array.addLast(t);
    }

    public T pop() {
        return array.removeLast();
    }

    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack :");
        res.append("[");
        for (int i = 0 ; i < array.getSize() ; i++){
            res.append(array.get(i));

            if(i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
