package com.company;

public class Main {

    private final static Object obj1 = new Object();
    private final static Object obj2 = new Object();

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1(obj1,obj2);
        MyThread2 myThread2 = new MyThread2(obj1,obj2);
        myThread1.start();
        myThread2.start();
    }
}

class MyThread1 extends Thread{

    private Object object1,object2;

    public MyThread1(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("I am thread1");
            }
        }
    }
}

class MyThread2 extends Thread{

    private Object object1,object2;

    public MyThread2(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }
    @Override
    public void run() {

        synchronized (object2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println("I am thread2");
            }
        }
    }
}
