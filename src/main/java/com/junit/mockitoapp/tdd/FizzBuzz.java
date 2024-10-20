package com.junit.mockitoapp.tdd;

public class FizzBuzz {
    public static String compute(int i) {

        StringBuilder sb = new StringBuilder();
        if(i%3==0){
            sb.append("Fizz");
        }

        if (i%5==0){
            sb.append("Buzz");
        }
        return sb.isEmpty()?sb.append(i).toString(): sb.toString();
    }
}
