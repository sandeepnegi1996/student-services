package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.ConcurrentReferenceHashMap;

public class HashMapTest extends Thread {

    static Map<Integer, String> l = new ConcurrentHashMap<>();

    public void run() {
        try {

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is writing to the hashMap");
            l.put(103, "D");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Writing to hashMap
        l.put(100, "A");
        l.put(101, "B");
        l.put(102, "C");

        // Created and started another thread
        HashMapTest t = new HashMapTest();
        t.start();

        // Main thread is reading from the hashMap
        // At the same time another thread is writing, so we get
        // ConcurrentModificationException
        for (Object o : l.entrySet()) {

            System.out.println(Thread.currentThread().getName() + "  :  is reading from the hashmap");
            System.out.println(o);
            Thread.sleep(1000);
        }

        // printing the final ConcurrnetHashMap to make sure the update is done
        // successfully
        System.out.println(l);
    }
}