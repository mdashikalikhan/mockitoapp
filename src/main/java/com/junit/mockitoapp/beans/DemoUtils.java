package com.junit.mockitoapp.beans;

public class DemoUtils {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public Object checkNull(Object obj) {
        if(obj==null){
            return null;
        }
        return obj;
    }
}