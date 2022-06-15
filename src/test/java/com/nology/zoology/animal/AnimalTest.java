package com.nology.zoology.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    private Animal animal = new Tiger(42, "Tony", 7);

    @Test
    void getId_ValidData_ReturnsId() {
        assertEquals( 42, animal.getId() );
    }

    @Test
    void setId_ValidInput_Success() {
        animal.setId(999);
        assertEquals( 999, animal.getId() );
    }

    @Test
    void getName_ValidData_ReturnsName() {
        assertEquals( "Tony", animal.getName() );
    }

    @Test
    void setName_ValidInput_Success() {
        animal.setName("Terry");
        assertEquals( "Terry", animal.getName() );
    }

    @Test
    void getAge_ValidData_ReturnsId() {
        assertEquals( 7, animal.getAge() );
    }

    @Test
    void setAge_ValidInput_Success() {
        animal.setAge(12);
        assertEquals( 12, animal.getAge() );
    }

    @Test
    void makeSound() {
    }

    @Test
    void toString_ValidInput_ReturnsString() {
        assertEquals("Tiger[id=42, name='Tony', age=7]", animal.toString());
    }
}