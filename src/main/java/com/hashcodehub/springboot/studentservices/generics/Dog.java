package com.hashcodehub.springboot.studentservices.generics;

public class Dog {

    private String breed;

    public Dog(String breed) {
        this.breed= breed;
    }

    @Override
    public String toString(){
        return breed;
    }
}
