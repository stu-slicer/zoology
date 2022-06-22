package com.nology.zoology.animal;

public class ZooPlayground {

    public static void main(String[] args) {

        Tiger tiger = new Tiger();
        tiger.setName("Tony");
        tiger.setId(1);
        tiger.setAge(12);

        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");

        Llama larry = new Llama();
        larry.setId(2);
        larry.setName("Larry");
        larry.setAge(4);

        Crocodile cuddles = new Crocodile();
        cuddles.setId(3);
        cuddles.setName("Cuddles");
        cuddles.setAge(17);

        ZooPlayground playground = new ZooPlayground();
        Tiger tiddles = playground.buildTiger(4, "Tiddles", 12);

    }

    // Extension
    public Tiger buildTiger(int id, String name, int age) {
        Tiger tiger = new Tiger();
        tiger.setId(id);
        tiger.setName(name);
        tiger.setAge(age);
        return tiger;
    }

}
