package com.hashcodehub.springboot.studentservices.generics;

import java.util.LinkedList;
import java.util.List;

public class MainClassGeneric {
    public static void main(String[] args) {

/*        Printer<Integer> printer = new Printer<Integer>(23);
        printer.print();

        Printer<Double> doublePrinter =  new Printer<Double>(23.4);
        doublePrinter.print();

        Printer<String> stringPrinter = new Printer<String>("this is string printer using generics ");
        stringPrinter.print();

        Dog c1 =new Dog("shitzo");

        Printer<Dog> catPrinter = new Printer<>(c1);
        catPrinter.print();*/


//        printAnything("hello ",12);
//        printAnything(123,"1234");
//        printAnything(23.0,"sdfsdf");

        /*generics part 2 baeldung */

        List<Integer> list = new LinkedList();
        list.add(new Integer(1));

        Integer i =  list.iterator().next();




    }


    private static <T,V> void printAnything(T anything, V secondAnything) {
        System.out.println(anything+"!!!!");
        System.out.println(secondAnything+"****");
    }




}
