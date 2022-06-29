package com.nology.zoology.user;

public class Visitor extends User {

    /**
     * A visitor can given one or more stars to animals they like.
     */
    private int stars;
    /**
     * A percentage of a user's happiness at the Zoo.
     */
    private int happiness;

    /**
     * Full constructor for creating a new {@link Visitor} object.
     *
     * @param name
     * @param password
     * @param email
     * @param id
     */
    public Visitor(String name, String password, String email, int id) {
        super(name, password, email, id);
    }

}
