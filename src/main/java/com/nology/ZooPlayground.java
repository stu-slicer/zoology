package com.nology;

import com.nology.zoology.animal.Tiger;

public class ZooPlayground {

    public static void main(String[] args) {
        Tiger tiger = new Tiger(1, "Tony", 12);
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
    }



}
