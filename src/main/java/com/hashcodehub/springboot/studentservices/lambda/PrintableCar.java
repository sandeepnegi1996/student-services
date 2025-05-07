package com.hashcodehub.springboot.studentservices.lambda;

public class PrintableCar implements Printable {
    @Override
    public void print() {
        System.out.println("printable car ");
    }
}
