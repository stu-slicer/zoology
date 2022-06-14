package com.nology;

import com.nology.zoology.animal.Tiger;

public class ZooPlayground {

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.setName("Tony");
        tiger.setId(1);
        tiger.setAge(12);

        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
    }

}
