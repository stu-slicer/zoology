package com.nology.zoology.user;

/**
 * A {@link ZooKeeper} represents a special user who has extra privileges, for example they
 * can feed the animals.
 * A ZooKeeper must have a password so they can login.
 */
public class ZooKeeper extends User {

    /**
     * Full constructor for creating a new {@link ZooKeeper} object.
     *
     * @param name
     * @param password
     * @param email
     * @param id
     */
    public ZooKeeper(String name, String password, String email, int id) {
        super(name, password, email, id);
    }

}
