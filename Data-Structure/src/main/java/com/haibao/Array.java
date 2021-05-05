package com.haibao;

/**
 *
 * 动态数组
 * @author ml.c
 * @date 19:01 PM 4/22/21
 **/
public class Array<T> {

    private T[] data;
    private int size;

    /**
     * 有参构造
     * @param capacity 初始容量
     */
    public Array(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造
     */
    public Array() {
        this(100);
    }

    /**
     * 获取数据中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapactiy(){
      return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e 要添加的元素
     */
    public void addLast(T e){
        add(size,e);
    }

    /**
     * 向所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(T e){
        add(0,e);
    }

    /**
     * 在指定的第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,T e){
        if(size == data.length){
           resize();
        }

        if(index < 0 || index > size){
            // 扩容 或者 抛出异常
            throw new IllegalArgumentException("add fail,index is Illegal");
        }

        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    /**
     * 查找是否存在元素e
     * @param e
     * @return true / false
     */
    public boolean contains(T e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    public T get(int index){
        if(index < 0 || index >= size){
          throw new IllegalArgumentException("Get faild. Index is Illegal.");
        }
        return data[index];
    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size -1);
    }


    /**
     * 查找是否存在元素e，并返回元素e的索引
     * 如果不存在，返回-1
     * @param e
     * @return 索引位置
     */
    public int find(T e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找所有元素e，并返回所有索引
     * @param e
     * @return
     */
    public int[] findAll(T e){
        int[] indexs = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                indexs[j] = i;
                j++;
            }
        }
        return indexs;
    }

    /**
     * 根据索引，删除 元素，并返回元素
     * @param index
     * @return
     */
    public T remove(int index){

       if(index < 0 || index > size){
           throw new IllegalArgumentException("remove failed.Index is Illegal");
       }

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        //loitering objects 闲散对象，等待GC
        data[size] = null;

        //缩容
        //防止复杂度的震荡 lazy
        if(size < data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除第一个索引,返回删除的元素
     * @return
     */
    public T removeFirst(){
        return this.remove(0);
    }

    /**
     * 删除最后一个索引，返回删除的元素
     * @return
     */
    public T removeLast(){
        return this.remove(size - 1);
    }

    /**
     * 删除一个元素e
     * @param e
     */
    public boolean removeElement(T e){
       int index = find(e);
       if(index != -1){
           remove(index);
           return true;
       }
       return false;
    }

    /**
     * 删除所有元素e
     * @param e
     * @return
     */
    public boolean removeAllElement(T e){
        int[] indexs = findAll(e);
        if(indexs.length > 0 ){
            for (int i = 0; i < indexs.length; i++) {
                remove(indexs[i]);
            }
            return true;
        }
        return false;
    }


    /**
     * 默认 扩容 2倍
     */
    private void resize(){
        resize(getCapactiy() * 2);
    }

    /**
     * 扩容，指定 容量
     * @param newCapactiy
     */
    private void resize(int newCapactiy){

        T[] newData = (T[])new Object[newCapactiy];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array, size = %d, capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
