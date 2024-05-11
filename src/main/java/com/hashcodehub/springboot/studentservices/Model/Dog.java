package com.hashcodehub.springboot.studentservices.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dog {

    @JsonProperty("Doggy_Name")
    private String dogName;

    public Dog(){

    }
    public Dog(String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                '}';
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
