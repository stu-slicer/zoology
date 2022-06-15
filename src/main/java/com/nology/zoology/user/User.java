package com.nology.zoology.user;

public class User {

    private String name;
    private String password;
    private String email;
    private int id;

    /**
     * Full constructor for creating a new {@link User} object.
     * @param name
     * @param password
     * @param email
     * @param id
     */
    public User(String name, String password, String email, int id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Complete the canAuthenticate() method.
     *
     * It should return true if the user's password is not null and not an empty String, otherwise it should return false.
     *
     * @return true if user's password is not null and not an empty String, otherwise false.
     */
    public boolean canAuthenticate() {
        throw new UnsupportedOperationException("No implemented yet");
    }
    /**
     * Complete the #isValidEmail() method.
     *
     * Should return true if the user's email address is not null and not an empty String.
     * Bonus: Validate the format of the email address.
     *
     * @return true if the user's email address is not null and not an empty String.
     */
    public boolean isValidEmail() {
        throw new UnsupportedOperationException("No implemented yet");
    }

    /**
     * Complete the method #authenticate.
     *
     * Should return true if the password given equals the user's password.
     * Allow for a null or empty password!
     *
     * @param password the password to authenticate.
     * @return true if the password given equals the user's password.
     */
    public boolean authenticate(String password) {
        throw new UnsupportedOperationException("No implemented yet");
    }


}
