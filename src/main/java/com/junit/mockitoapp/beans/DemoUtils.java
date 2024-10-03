package com.junit.mockitoapp.beans;

import lombok.Getter;

import java.util.List;

@Getter
public class DemoUtils {

    private String str="Sample";

    private String strDuplicate = str;

    private int[] integers = {5,4,3,2,1};

    private List<String> strList = List.of("ABC", "DEF", "GHI");

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return (double) num1 / num2;
    }

    public Object checkNull(Object obj) {
        if(obj==null){
            return null;
        }
        return obj;
    }

    public  boolean isGreater(int num1, int num2) {
        return num1 > num2;
    }

    public void timeout() throws InterruptedException {
        Thread.sleep(10000);
    }
}
