package org.nwolfhub.db;

import java.util.List;

public class Wrestler {
    private final String name;
    private final String photo;

    public Wrestler(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }
}
