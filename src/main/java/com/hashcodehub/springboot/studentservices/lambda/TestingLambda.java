package com.hashcodehub.springboot.studentservices.lambda;

public class TestingLambda {

    public static void main(String[] args) {


//        this is one type of object
        PrintableCar printableCarReferenceVariable = new PrintableCar();
        printAnything(printableCarReferenceVariable);


        // lets do the same thing but without the child class using lambda expression

        Printable secondPrintableCar = () -> {
            System.out.println("second printable car ");
        };

        printAnything(secondPrintableCar);
    }

    public static void printAnything(Printable printableInterface) {
        printableInterface.print();
    }
}
