package com.haibao;

/**
 * 栈 接口
 * @param <T>
 */
public interface Stack<T> {

    int getSize();
    boolean isEmpty();
    void push(T t);
    T pop();
    T peek();
}
