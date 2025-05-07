package com.hashcodehub.springboot.studentservices.generics;

public class Printer<T> {

     T value;

    public Printer(T value) {
        this.value= value;
    }

    public void print() {
        System.out.println(value);
    }
}
