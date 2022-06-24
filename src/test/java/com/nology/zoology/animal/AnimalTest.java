package com.nology.zoology.animal;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith( AnimalBeforeEachCallback.class )
class AnimalTest {

    private static final int ANIMAL_ID = 1;
    private static final String ANIMAL_NAME = "George";
    private static final int ANIMAL_AGE = 7;

    private Animal target;

    public AnimalTest() {
        System.out.println("Creating new AnimalTest!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Creating new Animal");
        this.target = new Animal( ANIMAL_ID, ANIMAL_NAME, ANIMAL_AGE );
    }

    @AfterEach
    void tidyUp() {
        System.out.println("Sweeping up after animal");
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Should run once");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Sweeping up after all animals!");
    }


    @Test
    @DisplayName("Get id is successful")
    void getId_ValidData_ReturnsId() {
        assertEquals( ANIMAL_ID, target.getId() );
    }

    @Test
    @DisplayName("Set id is successful")
    void setId_ValidInput_Success() {
        assertEquals( 1, target.getId() );
        target.setId(2);
        assertEquals( 2, target.getId() );
    }

    @Test
    @DisplayName("Tiger is hungry")
    void isHungry_Hunger50_ReturnsTrue() {
        target.setHunger((short) 50);

        assertTrue( target.isHungry(), "Tiger is hungry" );
    }

    @Test
    @DisplayName("Tiger is not hungry")
    void isHungry_Hunger10_ReturnsFalse() {
        target.setHunger((short) 10);

        assertFalse( target.isHungry(), "Tiger is not hungry" );
    }

    @Test
    @DisplayName("Feeding reduces hunger")
    void feed_NoInputs_ReducesHunger() {
        target.feed();
        assertEquals(40, target.getHunger());
    }

    @Test
    void testToString() {
        assertEquals("Animal[id=1, name='George', age=7]", target.toString());
    }
}