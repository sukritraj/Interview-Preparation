package com.example.design.test;

public class MultiThread extends Thread {
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {

            if(Thread.currentThread().getId()  == 21 && i % 2 == 0) {
                System.out.println(i);
            }
            if(Thread.currentThread().getId()  == 22 && i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001,2147483647));
    }

    public static double myPow(double x, int n) {
        if( n == 1) {
            return x;
        }
        n = n - 1;
        return x * myPow(x,n);
    }

}
