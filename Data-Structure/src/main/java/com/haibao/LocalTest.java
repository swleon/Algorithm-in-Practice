package com.haibao;

import org.junit.jupiter.api.Test;

/**
 *  测试
 *
 * @author ml.c
 * @date 19:07 PM 4/22/21
 **/
public class LocalTest {


    /**
     * 测试数组
     */
    @Test
    public void testArray(){

        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        array.add(1,100);
        System.out.println(array.toString());

        int e = array.find(100);
        System.out.println(e);

        array.remove(2);
        array.removeElement(100);
        System.out.println(array.toString());

        array.add(1,100);
        array.add(2,100);
        System.out.println(array.toString());

        array.removeAllElement(100);
        System.out.println(array.toString());

        for (int i = 0; i < 100; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        for (int i = 99; i > 40; i--) {
            array.remove(i);
        }
        System.out.println(array.toString());

    }
}
