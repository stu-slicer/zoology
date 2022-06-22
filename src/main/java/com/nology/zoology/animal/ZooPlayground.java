package com.nology.zoology.animal;

public class ZooPlayground {

    public static void main(String[] args) {
        Tiger tiger = new Tiger(1, "Tony", 12);
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");

        Llama larry = new Llama(2, "Larry", 4);
        System.out.println("Larry " + larry.getName() + " is " + larry.getAge() + " years old");

        Crocodile cuddles = new Crocodile(3, "Cuddles", 17);

    }

}
