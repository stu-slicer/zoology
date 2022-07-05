package com.nology.zoology.animal;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private static final int ANIMAL_ID = 1;
    private static final String ANIMAL_NAME = "George";
    private static final int ANIMAL_AGE = 7;
    private static final short STANDARD_HUNGER = 50;

    private Animal target;

    public AnimalTest() {
        System.out.println("Creating new AnimalTest!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Creating new Animal");
        this.target = buildAnonymousAnimal( ANIMAL_ID, ANIMAL_NAME, ANIMAL_AGE );
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
    @DisplayName("Set name is successful")
    void setName_ValidInput_Success() {
        assertEquals( ANIMAL_NAME, target.getName() );
        target.setName( "Lotte" );
        assertEquals( "Lotte", target.getName() );
    }

    @Test
    @DisplayName("Set null name throws exception")
    void setName_Null_ThrowsException() {
        assertThrows( IllegalArgumentException.class,
                () -> target.setName(null) );
    }

    @Test
    @DisplayName("Set empty string name throws exception")
    void setName_EmptyString_ThrowsException() {
        assertThrows( IllegalArgumentException.class,
                () -> target.setName("") );
    }

    @Test
    @DisplayName("Set age is successful")
    void setAge_ValidInput_Success() {
        assertEquals( ANIMAL_AGE, target.getAge() );
        target.setAge( 42 );
        assertEquals( 42, target.getAge() );
    }

    @Test
    @DisplayName("Set age to 0 throws exception")
    void setAge_ZeroInput_ThrowsException() {
         assertThrows( IllegalArgumentException.class,
                () -> target.setAge(0) );
    }

    @Test
    @DisplayName("Set age to 101 throws exception")
    void setAge_InvalidInput_ThrowsException() {
         assertThrows( IllegalArgumentException.class,
                () -> target.setAge(101) );
    }

    @Test
    @DisplayName("Set hunger is successful")
    void setHunger_ValidInput_Success() {
        assertEquals( STANDARD_HUNGER, target.getHunger() );
        target.setHunger((short) 44);
        assertEquals( 44, target.getHunger() );
    }

    @Test
    @DisplayName("Set hunger to invalid range")
    void setHunger_InalidInput_ThrowsException() {
        assertThrows( IllegalArgumentException.class,
                () -> target.setHunger((short) -1) );
        assertThrows( IllegalArgumentException.class,
                () -> target.setHunger((short) 101) );
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
    @DisplayName("toString() produces expected output")
    void testToString() {
        assertEquals("[id=1, name='George', age=7]", target.toString());
    }

    private Animal buildAnonymousAnimal(int id, String name, int age) {
        return new Animal(id, name, age) {
            @Override
            public AnimalType getType() {
                return AnimalType.lion;
            }

            @Override
            public void makeSound() {
                System.out.println("Roarrrrrr!!");
            }
        };
    }
}