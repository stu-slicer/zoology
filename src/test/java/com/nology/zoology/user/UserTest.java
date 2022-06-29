package com.nology.zoology.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User validUser;
    private User noPasswordUser;
    private User noEmailUser;

    @BeforeEach
    void setUp() {
        this.validUser = new User("Arthur Dent", "Password123", "arthur@nology.com", 42);
        this.noPasswordUser = new User("Jane Smith", "", "jane@google.com", 88);
        this.noEmailUser = new User("Brian May", "password321", " ", 102);
    }

    @Test
    void canAuthenticate_ValidData_ReturnsTrue() {
        assertTrue(validUser.canAuthenticate() );
        assertTrue(noEmailUser.canAuthenticate() );
    }

    @Test
    void canAuthenticate_InvalidData_ReturnsFalse() {
        assertFalse(noPasswordUser.canAuthenticate() );
    }

    @Test
    void isValidEmail_ValidData_ReturnsTrue() {
        assertTrue(validUser.isValidEmail() );
        assertTrue(noPasswordUser.isValidEmail() );
    }

    @Test
    void isValidEmail_InvalidData_ReturnsFalse() {
        assertFalse(noEmailUser.isValidEmail() );
    }

    @Test
    void authenticate_ValidPassword_ReturnsTrue() {
        assertTrue(validUser.authenticate("Password123") );
    }

    @Test
    void authenticate_InvalidPassword_ReturnsFalse() {
        assertFalse(validUser.authenticate("password") );
    }

    @Test
    void authenticate_NoPassword_ReturnsFalse() {
        assertFalse(noPasswordUser.authenticate("password") );
    }

    @Test
    void getName_ValidData_ReturnsName() {
        assertEquals( "Arthur Dent", validUser.getName() );
        assertEquals( "Jane Smith", noPasswordUser.getName() );
        assertEquals( "Brian May", noEmailUser.getName() );
    }

    @Test
    void setName_ValidInput_Success() {
        validUser.setName("Freddie Mercury");
        assertEquals( "Freddie Mercury", validUser.getName() );
    }

    @Test
    void getEmail_ValidData_ReturnsEmail() {
        assertEquals( "arthur@nology.com", validUser.getEmail() );
        assertEquals( "jane@google.com", noPasswordUser.getEmail() );
        assertEquals( " ", noEmailUser.getEmail() );
    }

    @Test
    void setEmail_ValidInput_Success() {
        validUser.setEmail("new_email@gmai.com");
        assertEquals( "new_email@gmai.com", validUser.getEmail() );
    }

    @Test
    void setEmail_NullInput_Success() {
        validUser.setEmail(null);
        assertEquals( null, validUser.getEmail() );
    }

    @Test
    void getId_ValidData_ReturnsId() {
        assertEquals( 42, validUser.getId() );
        assertEquals( 88, noPasswordUser.getId() );
        assertEquals( 102, noEmailUser.getId() );
    }

    @Test
    void setId_ValidInput_Success() {
        validUser.setId(999);
        assertEquals( 999, validUser.getId() );
    }

}